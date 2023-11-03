public class Vendor extends User{

    private String vendorName;
    private double balance = 0;

    private Vendor() { //Private default constructor to prevent instantiation due to class having factory methods for instantiation

    }

    public static Vendor createForLogin(String id, String password){ //Static factory method for login due to same parameter types cant be used in overloading constructor, used like -> Vendor vendorLogIn = vendorLogIn.createForLogin("V123", "pass123")
        Vendor vendor = new Vendor();
        vendor.setId(id);
        vendor.setPass(password);
        return vendor;
    }

    public static Vendor createForRegistration(String password, String vendorName){ //Static factory method for registration due to same parameter types cant be used in overloading constructor, used like -> Vendor vendorRegistration = Vendor.createForRegistration("V123", "Chinese Food")
        Vendor vendor = new Vendor();
        vendor.setPass(password);
        vendor.vendorName = vendorName;
        return vendor;
    }

    public String getName() { //
        return vendorName;
    }

    public void addBal(Double profit){ //Profit for ordered foods
        balance = balance + profit;
    }

    @Override
    public String toString() { //For writing to TextFile during registration
        return "V" + super.getId() + "," + super.getPass() + "," + vendorName + "," + balance;
    }
}
