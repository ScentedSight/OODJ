public class Food implements DataProvider {
    
    private String id;
    private String description;
    private double cost;
    private Vendor vendor;
    private String vendorName; //Pass vendor's details when food is created to list it under the vendor's menu
    
    public Food(Vendor vendor, String name, double cost) { //Ask for food's details the instance the object is created
        description = name;
        this.cost = cost;
        this.vendor = vendor;
        this.vendorName = vendor.getName();
        id = vendor.getId() + ":" + description; //Food id consists of vendor's ID + description with a delimiter of ":"
    }
    
    public String getId() {
        return id;
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

    public String getVendor() {
        return vendorName;
    }
}
