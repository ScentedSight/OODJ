public class Vendor extends User{

    private String vendorName;
    private double balance = 0;

    public Vendor (String id, String password) { //Log in
        super(id, password);
    }

    public Vendor (String id, String password, String vendorName) { //Registration
        super(id, password);
        this.vendorName = vendorName;
    }

    public String getName() {
        return vendorName;
    }

    public void addProfit(Double profit){ //Profit for ordered foods
        balance = balance + profit;
    }
    
    
    
    
}
