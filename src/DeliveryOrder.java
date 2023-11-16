public class DeliveryOrder extends Order{
    
    private DeliveryRunner runner;
    private double deliveryFee = 2.50; //Delivery is for within campus only, thus distance and delivery fee are fixed
    private Status statusRunner;
    
    public DeliveryOrder(String vendorId, String vendorName, Customer customer, String foodName, String foodId, double foodCost) {
        super(vendorId, vendorName, customer, foodName, foodId, foodCost);
        super.setCost(foodCost + deliveryFee);
    }
    
    public void setRunner (DeliveryRunner runner) { //To set designated runner after found
        this.runner = runner;
    }
    
    @Override
    public String getId() { //Order ID is made of vendor ID + customer ID + runner ID (If it was a delivery)
        return runner.getId() + ":" + super.getId();
    }
    
    public String getRunner() {
        return runner.getId();
    }
    
    public void setRunnerStatus(Status status) { //For runner to set statuses
        statusRunner = status;
    }
    
    public void runnerProfit() { //Can only be called if status = DELIVERED, before this object is deleted after saving to history
        runner.addBal(deliveryFee);
    }
    
    @Override
    public String toString() { //For writing to order history
        return runner.getId() + super.toString() + "," + super.getAddress();
    }
}
