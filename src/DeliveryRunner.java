public class DeliveryRunner extends User{

    private static int id = 001;
    private int deliveryRunnerId;
    private double balance = 0;

    public DeliveryRunner(){
        id++;
        deliveryRunnerId = id;
    }

    public int getId(){
        return deliveryRunnerId;
    }

    public double getBal(){
        return balance;
    }

    @Override
    public String toString() {
        return "D" + deliveryRunnerId;
    }
}
