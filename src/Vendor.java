public class Vendor extends User{

    private static int id = 001;
    private String vendorId;
    private String vendorName;
    private double balance = 0;

    public Vendor(){ //For logging in purpose, attributes will be filled from TextFiles

    }

    public Vendor(String password, String vendorName){ //Only for registration, passing password parameter back into inherited attribute
        super(password);
        this.vendorName = vendorName;
        vendorId = Integer.toString(id);
        id++;
    }

    public String getId(){ //For retrieving Id in ordering process and menu creation
        return vendorId;
    }

    public void addBal(Double profit){ //Profit for ordered foods
        this.balance = balance + profit;
    }

    @Override
    public String toString() { //For writing to TextFile during registration
        return "V" + vendorId + "," + vendorName + balance;
    }
}
