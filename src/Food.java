public class Food implements DataProvider {
    
    private String name;
    private static int id = 001; //Static to keep unique id for any subsequently created foods
    private String foodId;
    private double cost;
    private Vendor vendor; //Pass vendor's details when food is created to list it under the vendor's menu
    
    public Food(Vendor vendor, String name, double cost) { //Ask for food's details the instance the object is created
        foodId = Integer.toString(id);
        id++;
        this.name = name;
        this.cost = cost;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public String getId(){
        return foodId;
    }
    
    public void setCost(double cost){
        this.cost = cost;
    }
    
    public double getCost(){
        return cost;
    }

    public String getVendor(){
        return vendor.getId();
    }

    @Override
    public String toString() { //Writing to textfile
        return vendor.getId() + "," + foodId + "," + name + "," + cost;
    }
}
