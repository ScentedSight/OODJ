public class DeliveryRunner extends User{

    private double balance = 0;

    public DeliveryRunner(String id, String password) {
        super(id, password);
    }
    
    public DeliveryRunner(String id, String email, String gender, String phoneNo, String password) { //Registration
        super(id, email, phoneNo, gender, password);
    }

    public void addBal(double deliveryFee){ //Profit for delivering food
        balance = balance + deliveryFee;
    }
}
