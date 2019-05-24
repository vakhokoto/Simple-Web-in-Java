package Info;

/**
 * This is a class which stores Cart information item which are selected
 * number of each items user wants to buy and
 * This is a singleton class in the case but it can be modified so as to be single for the user but not a singleton
 * */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingCart {
    private static ShoppingCart cart;
    private static HashMap<String, Product> data;
    private static HashMap<String, Integer> number;

    public static final String ATTRIBUTE_NAME = "shoppingCart";

    private ShoppingCart(){
        data = new HashMap<>();
        number = new HashMap<>();
    }

    /**
     * This method returns the numbe of different type of items
     *
     * @return int the number of different type of items in the cart
     * */
    public int itemNum(){
        return data.size();
    }

    /**
     * This method returns list of product information but not the number
     *
     * @return List<Product> products in the cart
     * @see Info.Product
     * */
    public List<Product> getItemList(){
        List<Product> ansList = new ArrayList<>();
        for (String id : data.keySet()) {
            ansList.add(data.get(id));
        }
        return ansList;
    }

    /**
     * This method adds new item in the cart with quantity eqal to 1
     *
     * @param newProduct item to be added
     * @see Info.Product
     * */
    public void addItem(Product newProduct){
        data.put(newProduct.getId(), newProduct);
        number.put(newProduct.getId(), 1);
    }

    /**
     * This method returns the product info by for the product with specified id
     *
     * @param id ID of the item
     * @return Product information for the product
     * @see Info.Product
     * */
    public Product getItem(String id){
        return data.get(id);
    }

    /**
     * This method updates number of the specified item in the cart
     *
     * @param id ID of the item
     * @param newNumber new number of item to be in the cart
     * */
    public void updateItemNumber(String id, int newNumber){
        number.put(id, newNumber);
    }

    /**
     * This method returns number of the specified item in the cart
     *
     * @param id items id
     * @return numver of the item with id equal to "id"
     * */
    public int getItemNumber(String id){
        return number.get(id);
    }

    /**
     * This method tells you whether the items is in the cart
     *
     * @param id id of the item
     * @return true if item is in the cart
     *          false otherwise
     * */
    public boolean containsItem(String id){
        return data.containsKey(id);
    }

    /**
     * This method removes item from the cart
     *
     * @param id id of the item
     * */
    public void remove(String id){
        data.remove(id);
        number.remove(id);
    }

    /**
     * Because the class is singleton in the case it needs gteInstance method to create
     * new instance of the type and this is the one for this class
     *
     * @return ShoppingCart the cart which is singleton
     * */
    public static ShoppingCart getInstance(){
        if (cart == null){
            synchronized (ShoppingCart.class){
                if (cart == null){
                    cart = new ShoppingCart();
                }
            }
        }
        return cart;
    }
}
