public class DeliveryRunner extends User{

    private static int id = 001;
    private String runnerId;
    private double balance = 0;

    public DeliveryRunner(){ //For logging in purpose, attributes will be filled from TextFiles

    }

    public DeliveryRunner(String password){ //Only for registration, passing password parameter back into inherited attribute
        super(password);
        runnerId = Integer.toString(id);
        id++;
    }

    public String getId(){ //For retrieving Id in delivering process
        return runnerId;
    }

    public void addBal(double deliveryFee){ //Profit for delivering food
        balance = balance + deliveryFee;
    }

    @Override
    public String toString() { //For writing to TextFile during registration
        return "D" + runnerId + "," + super.getPass() + "," + balance;
    }
}
