public class Vendor extends User{

    private String vendorName;
    private double balance = 0;

    public Vendor(){
        
    }
    
    public Vendor (String id, String password) { //Log in
        super(id, password);
    }

    public Vendor (String id, String vendorName, String email, String phoneNo, String gender,  String password, double balance) { //Registration
        super(id, email, phoneNo, gender, password);
        this.vendorName = vendorName;
    }
    
    public void setName(String vendorName) {
        this.vendorName = vendorName;
    }
    
    public String getName() {
        return vendorName;
    }
    
    public double getBal(){
        return balance;
    }

    public void addProfit(Double profit){ //Profit for ordered foods
        balance = balance + profit;
    }
}
