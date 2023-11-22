public class DeliveryOrder extends Order{
    
    private DeliveryRunner runner;
    private double deliveryFee = 2.50; //Delivery is for within campus only, thus distance and delivery fee are fixed
    private Status statusRunner;
    
    public DeliveryOrder(String vendorId, String vendorName, Customer customer, String food, double foodCost) {
        super(vendorId, vendorName, customer, food, foodCost);
        super.setCost(foodCost + deliveryFee);
        statusRunner = Status.SEARCHING; //Set status so that runner frame code can read orders for deliveries, if order (status = canceled *MUST* statusRunner = canceled)
    }
    
    public void setRunner (DeliveryRunner runner) { //To set designated runner after found
        this.runner = runner;
    }
    
    public String getRunner() {
        return runner.getId();
    }
    
    public void setRunnerStatus(Status status) {
        statusRunner = status;
    }
    
    public void runnerProfit() { //Can only be called if status = DELIVERED, before this object is deleted after saving to history
        runner.addBal(deliveryFee);
    }
}
