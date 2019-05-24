package Info;

/**
 * This is class for storing item information
 * includinf ID, name, price and image name
 *
 * @author Vakho Kotoreishvili
 * */

public class Product {
    private String id, name, imgName;
    private double price;

    public Product(String id, String name, String imgName, double price){
        this.id = id;
        this.name = name;
        this.imgName = imgName;
        this.price = price;
    }

    /**
     * This method returns id of the product
     *
     * @return String id of product
     * */
    public String getId(){
        return id;
    }

    /**
     * This method returns name of the product
     *
     * @return String name of product
     * */
    public String getName(){
        return name;
    }

    /**
     * This method returns image name of the product
     *
     * @return String image name of product
     * */
    public String getImgName(){
        return imgName;
    }

    /**
     * This method returns price of the product
     *
     * @return double price of product
     * */
    public double getPrice(){
        return price;
    }
}
