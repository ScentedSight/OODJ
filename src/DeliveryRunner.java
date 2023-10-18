public class DeliveryRunner extends User{

    private static int id = 001;
    private int runnerId;
    private double balance = 0;

    public DeliveryRunner(){
        id++;
        runnerId = id;
    }

    public int getId(){
        return runnerId;
    }

    public double getBal(){
        return balance;
    }

    public void addBal(){

    }

    @Override
    public String toString() {
        return "D" + runnerId;
    }
}
