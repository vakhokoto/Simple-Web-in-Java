package Info;

/**
 * This is an singleton class  which provides you with database connection
 * which is itself singleton due to this wrapper function
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDBInfo {
        public static final String MYSQL_USERNAME = "root";
        public static final String MYSQL_PASSWORD = "password";
        public static final String MYSQL_DATABASE_SERVER = "jdbc:mysql://localhost:3306/";
        public static final String MYSQL_DATABASE_NAME = "sys";

        public static final String ATTRIBUTE_NAME = "databaseConnection";

        private static final String DROP = "DROP TABLE IF EXISTS products;";
        private static final String CREATE = "CREATE TABLE products (\n" +
                "\tproductid CHAR(6),\n" +
                "    name CHAR(64),\n" +
                "    imagefile CHAR(64),\n" +
                "    price DECIMAL(6,2)\n" +
                ");";
        /* This is an insertion fo info in database */
        private static String ADD_INFO = "INSERT INTO products VALUES\n" +
                "\t(\"HC\",\"Classic Hoodie\",\"Hoodie.jpg\",40),\n" +
                "    (\"HLE\", \"Limited Edition Hood\",\"LimitedEdHood.jpg\",54.95),\n" +
                "\t(\"TC\", \"Classic Tee\",\"TShirt.jpg\",13.95),\n" +
                "\t(\"TS\",\"Seal Tee\",\"SealTShirt.jpg\",19.95),\n" +
                "\t(\"TLJa\",\"Japanese Tee\",\"JapaneseTShirt.jpg\",17.95),\n" +
                "\t(\"TLKo\",\"Korean Tee\",\"KoreanTShirt.jpg\",17.95),\n" +
                "\t(\"TLCh\",\"Chinese Tee\",\"ChineseTShirt.jpg\",17.95),\n" +
                "\t(\"TLHi\",\"Hindi Tee\",\"HindiTShirt.jpg\",17.95),\n" +
                "\t(\"TLAr\",\"Arabic Tee\",\"ArabicTShirt.jpg\",17.95),\n" +
                "\t(\"TLHe\",\"Hebrew Tee\",\"HebrewTShirt.jpg\",17.95),\n" +
                "\t(\"AKy\",\"Keychain\",\"Keychain.jpg\",2.95),\n" +
                "\t(\"ALn\",\"Lanyard\",\"Lanyard.jpg\",5.95),\n" +
                "\t(\"ATherm\",\"Thermos\",\"Thermos.jpg\",19.95),\n" +
                "\t(\"AMinHm\",\"Mini Football Helmet\",\"MiniHelmet.jpg\",29.95);";
        private static final String COMMIT = "COMMIT;";
        private static Connection connection;

        /**
         * this method creates new instance of Connection type
         *
         * @see java.sql.Connection
         * */
        private static void createInstance(){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(MYSQL_DATABASE_SERVER + MYSQL_DATABASE_NAME, MYSQL_USERNAME, MYSQL_PASSWORD);
                Statement st = null;
                st = connection.createStatement();
                st.executeUpdate(DROP);
                st.executeUpdate(CREATE);
                st.executeUpdate(ADD_INFO);
                st.executeUpdate(COMMIT);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /**
         * This method gives you an instance of database connection
         *
         * @return Connestion a connection to database
         * */
        public static Connection getInstance(){
            if (connection == null){
                synchronized (MyDBInfo.class){
                    if (connection == null)
                        createInstance();
                }
            }
            return connection;
        }

        /**
         * This method is for closing of connection which is created by the class
         * */
        public static void closeConnection(){
            synchronized (MyDBInfo.class) {
                if (connection != null) {
                    try {
                        connection.close();
                        connection = null;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
}
