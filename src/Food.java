public class Food implements IdProvider {
    
    private String name;
    private static int id = 001;
    private int foodId;
    private double cost;
    private Vendor vendor;
    
    public Food(Vendor vendor) {
        id++;
        foodId = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public int getId(){
        return foodId;
    }
    
    public void setCost(double cost){
        this.cost = cost;
    }
    
    public double getCost(){
        return cost;
    }

    public int getVendor(){
        return vendor.getId();
    }

    @Override
    public String toString() {
        return foodId + "," + name + "," + cost;
    }
}
