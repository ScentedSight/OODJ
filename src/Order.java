public class Order implements DataProvider {

    private String status;
    private String review;
    private double total;
    private double deliveryFee = 2.50; //Delivery is for within campus only, thus distance is fixed and delivery fee too
    private Vendor vendor;
    private DeliveryRunner runner;
    private Customer customer;
    private Food food;
    private Time time;

    enum Status{
        PREPARING,
        READY,
        DONE,
        CANCELED,
        SEARCHING,
        DELIVERING,
        DELIVERED
    }

    public Order(Vendor vendor, Customer customer, Food food) { //For dine-in
        Time time = new Time();
        this.time = time;
        total = food.getCost();
    }

    public Order(Vendor vendor, Customer customer, Food food, DeliveryRunner runner) { //For deliveries
        Time time = new Time();
        this.time = time;
        total = food.getCost() + deliveryFee;
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
        return food.getName();
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
        vendor.addBal(food.getCost());
    }

    public void runnerProfit() { //Can only be called if status = DELIVERED, before this object is deleted after saving to history
        runner.addBal(total - food.getCost());
    }

    public void setStatus(Status status) {
        this.status = status.toString();
    }

    @Override
    public String toString() { //For writing to order history
        return vendor.getId() + ":" + customer.getId() + ":" + (runner != null ? runner.getId() : "") + "," + food.getId() + "," + food.getName() + "," + total + "," + time + "," + status + "," + review;
    }
}
