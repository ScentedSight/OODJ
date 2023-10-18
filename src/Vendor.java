public class Vendor extends User{

    private static int id = 001;
    private int vendorId;
    private double balance = 0;

    public Vendor(){
        id++;
        vendorId = id;
    }

    public int getId(){
        return vendorId;
    }

    public double getBal(){
        return balance;
    }

    public void addBal(Food food){
        this.balance = balance + food.getCost();
    }

    @Override
    public String toString() {
        return "V" + vendorId;
    }
}
