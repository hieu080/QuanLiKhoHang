
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HELLO
 */
public class Product {

    private String id;
    private String name;
    private String location;
    private double price;
    private String expirydate;
    private String dateOfManufacture;
    private String category;
    private Storekeeper storekeeper;
    private String receiptdate;

    public Product(String id, String name, String location, double price, String expirydate, String dateOfManufacture, String category, Storekeeper storekeeper, String receiptdate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.expirydate = expirydate;
        this.dateOfManufacture = dateOfManufacture;
        this.category = category;
        this.storekeeper = storekeeper;
        this.receiptdate = receiptdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Storekeeper getStorekeeper() {
        return storekeeper;
    }

    public void setStorekeeper(Storekeeper storekeeper) {
        this.storekeeper = storekeeper;
    }

    public String getReceiptdate() {
        return receiptdate;
    }

    public void setReceiptdate(String receiptdate) {
        this.receiptdate = receiptdate;
    }

    @Override
    public String toString() {
        return "Sản phẩm : " + "\nId : " + id + "\nName : " + name + "\nLocation : " + location + "\nPrice : " + price + "\nExpirydate : " + expirydate + "\nDateOfManufacture : " + dateOfManufacture + "\nCategory : " + category + "\nStorekeeper : " + storekeeper.getStorekeeperID() + "\t" + storekeeper.getStorekeeperName() + "\t" + storekeeper.getStorekeeperAge() + "\nReceiptdate : " + receiptdate;
    }

   
    
}
