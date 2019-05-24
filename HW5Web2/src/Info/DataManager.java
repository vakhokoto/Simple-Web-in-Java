package Info;

/**
 * This is wrapper class from server to DB to run queries get info back
 * and determine each item information
 * This is a singleton standard class which uses java.sql.Connection class to connect to the DB
 *
 * @see java.sql.Connection
 * */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    /* DB connection */
    private Connection con;

    private static final String GET_ALL = "SELECT productid FROM products;";

    public static final String ATTRIBUTE_NAME = "dataManager";
    private static DataManager manager;

    private DataManager(Connection connection){
        con = connection;
    }

    /**
     * This method is for getting IDs of the items listed in table currently
     *
     * @return List<String> IDs of the items in the DB
     * */
    public List<String> getIDs(){
        ArrayList <String> ans = new ArrayList<>();
        ResultSet set = runQuery(GET_ALL);
        try {
            while (true) {
                if (!set.next()) break;
                String id;
                id = set.getString(1);
                ans.add(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ans;
    }

    /**
     * This method returns information of the product all the method does is
     * running a query to DB to get product information
     *
     * @param id ID of the product the information you want about
     * @return Prosuct object which keeps information about item
     * @see Info.Product
     * */
    public Product getProductInfo(String id){

        Product res = null;
        String query = "select * from products where productid = " + "\"" + id +"\"" + ";";
        ResultSet set;
        try {
            Statement st = con.createStatement();
            set = st.executeQuery(query);
            set.next();
            res = new Product(set.getString(1), set.getString(2),
                    set.getString(3), Double.parseDouble(set.getString(4)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * This method runs query to the DB and gets back the set of information got back
     *
     * @param query Quehry to be run
     * @return ResultSet answer to the query
     * */
    private ResultSet runQuery(String query) {
        ResultSet set = null;
        try {
            Statement st = con.createStatement();
            set = st.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }

    /**
     * This is standard Singleton method which gets back a DataManager
     *
     * @param connection Connection which the object use to comunicate to DB
     * @return DataManager the singleton object of the class type
     * */
    public static DataManager getInstance(Connection connection){
        if (manager == null){
            synchronized (DataManager.class){
                if (manager == null){
                    manager = new DataManager(connection);
                }
            }
        }
        return manager;
    }
}
