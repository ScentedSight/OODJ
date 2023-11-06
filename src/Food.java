public class Food implements DataProvider {
    
    private String name;
    private double cost;
    private String vendorID; //Pass vendor's details when food is created to list it under the vendor's menu
    
    public Food(Vendor vendor, String name, double cost) { //Ask for food's details the instance the object is created
        this.name = name;
        this.cost = cost;
        this.vendorID = vendor.getId();
    }

    public String getId(){
        return name;
    }
    
    public void setCost(double cost){
        this.cost = cost;
    }
    
    public double getCost(){
        return cost;
    }

    @Override //For writing to menu text file
    public String toString() { //Writing to textfile
        return vendorID + ":" + name + "," + name + "," + cost;
    }
}
