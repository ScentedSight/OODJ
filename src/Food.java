import java.io.Serializable;

public class Food implements Serializable {

    private String description;
    private double cost;
    private String vendorID; //Pass vendor's details when food is created to list it under the vendor's menu
    
    public Food(Vendor vendor, String name, double cost) { //Ask for food's details the instance the object is created
        description = name;
        this.cost = cost;
        this.vendorID = vendor.getId();
    }

    public String getDescription(){
        return description;
    }
    
    public void setCost(double cost){
        this.cost = cost;
    }
    
    public double getCost(){
        return cost;
    }
}
