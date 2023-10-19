/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HELLO
 */
public class Storekeeper {
    private String storekeeperID;
    private String storekeeperName;
    private int storekeeperAge;

    public Storekeeper(String storekeeperID, String storekeeperName, int storekeeperAge) {
        this.storekeeperID = storekeeperID;
        this.storekeeperName = storekeeperName;
        this.storekeeperAge = storekeeperAge;
    }

    public String getStorekeeperID() {
        return storekeeperID;
    }

    public void setStorekeeperID(String storekeeperID) {
        this.storekeeperID = storekeeperID;
    }

    public String getStorekeeperName() {
        return storekeeperName;
    }

    public void setStorekeeperName(String storekeeperName) {
        this.storekeeperName = storekeeperName;
    }

    public int getStorekeeperAge() {
        return storekeeperAge;
    }

    public void setStorekeeperAge(int storekeeperAge) {
        this.storekeeperAge = storekeeperAge;
    }
    
    
}
