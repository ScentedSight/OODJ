public class Order implements DataProvider {

    private Status status;
    private Status statusRunner;
    private String review;
    private double total;
    private double deliveryFee = 2.50; //Delivery is for within campus only, thus distance is fixed and delivery fee too
    private String foodId;
    private double foodCost;
    private Vendor vendor;
    private DeliveryRunner runner;
    private Customer customer;
    private Time time;

    enum Status {
        PENDING,
        PREPARING,
        READY,
        COMPLETED,
        CANCELED,
        SEARCHING,
        DELIVERING,
        DELIVERED
    }

    public Order(Vendor vendor, Customer customer, String foodId, double foodCost) { //For dine-in
        status = Status.PENDING;
        Time time = new Time();
        this.time = time;
        this.vendor = vendor;
        this.customer = customer;
        this.foodId = foodId;
        total = foodCost;
    }

    public Order(Vendor vendor, Customer customer, String foodId, double foodCost, DeliveryRunner runner) { //For deliveries
        statusRunner = Status.SEARCHING;
        status = Status.PENDING;
        Time time = new Time();
        this.time = time;
        this.vendor = vendor;
        this.customer = customer;
        this.foodId = foodId;
        this.runner = runner;
        total = foodCost + deliveryFee;
    }
    
    public String getId() { //Order ID is made of vendor ID + customer ID + runner ID (If it was a delivery)
        return vendor.getId() + ":" + customer.getId() + ":" + (runner != null ? runner.getId() : "");
    }

    public void setReview(String review) { //Review should only be set when food status is done or delivered
        this.review = review;
    }

    public String getCustomer() {
        return customer.getId();
    }
    
    public String getFood() {
        return foodId;
    }

    public double getCost() {
        return foodCost;
    }

    public String getVendor() {
        return vendor.getId();
    }

    public String getRunner() { //Ternary operator, if it is a dine-in, runner ID will return empty string, else if delivery it will return runner ID
        return runner != null ? runner.getId() : "";
    }

    public String getTime() {
        return time.toString();
    }

    public void payment() {
        customer.deductBal(total);
        vendor.addBal(foodCost);
    }

    public void runnerProfit() { //Can only be called if status = DELIVERED, before this object is deleted after saving to history
        runner.addBal(total - foodCost);
    }

    public void setStatus(Status status) { //For vendor and customer to set statuses
        this.status = status;
    }
    
    public void setRunnerStatus(Status status) { //For runner to set statuses
        statusRunner = status;
    }
    
    @Override
    public String toString() { //For writing to order history
        return vendor.getId() + ":" + customer.getId() + ":" + (runner != null ? runner.getId() : "") + "," + vendor.getName() + "," + foodId + "," + total + "," + time + "," + status + "," + review;
    }
}
