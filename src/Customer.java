public class Customer extends User{

    private static int id = 001;
    private int customerId;
    private double balance = 0;

    public Customer(){
        id++;
        customerId = id;
    }

    public int getId(){
        return customerId;
    }

    public double getBal(){
        return balance;
    }

    @Override
    public String toString() {
        return "C" + customerId;
    }
}
