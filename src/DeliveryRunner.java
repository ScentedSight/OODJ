public class DeliveryRunner extends User{

    private double balance = 0;

    public DeliveryRunner(String id, String password){ //For logging in purpose, attributes will be filled from TextFiles
        super(id, password);
    }

    public DeliveryRunner(String password){ //Only for registration, passing password parameter back into inherited attribute
        super(password);
    }

    public void addBal(double deliveryFee){ //Profit for delivering food
        balance = balance + deliveryFee;
    }

    @Override
    public String toString() { //For writing to TextFile during registration
        return "D" + super.getId() + "," + super.getPass() + "," + balance;
    }
}
