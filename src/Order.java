public class Order implements DataProvider {
    
    private static int id = 001;
    private String orderId;
    private String status;
    private String review;
    private double total;
    private double deliveryFee = 2.50;
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

    public Order(Vendor vendor, Customer customer, Food food) {
        Time time = new Time();
        this.time = time;
        orderId = Integer.toString(id);
        total = food.getCost();
        id++;
    }

    public Order(Vendor vendor, Customer customer, Food food, DeliveryRunner runner) {
        Time time = new Time();
        this.time = time;
        orderId = Integer.toString(id);
        total = food.getCost() + deliveryFee;
        id++;
    }
    
    public String getId(){
        return orderId;
    }

    public void setReview(String review){
        this.review = review;
    }

    public String getReview(){
        return review;
    }
    
    public String getCustomer(){
        return customer.getId();
    }
    
    public String getFood(){
        return food.getName();
    }

    public String getTime(){
        return time.toString();
    }

    public void payment(){
        customer.deductBal(total);
        vendor.addBal(food.getCost());
    }

    public void runnerProfit(){ //Can only be called if status = DELIVERED
        runner.addBal(total - food.getCost());
    }

    public void setStatus(Status status){
        this.status = status.toString();
    }

    @Override
    public String toString() {
        return orderId + "," + customer.getId() + "," + food.getId() + "," + total + "," + time + "," + status + "," + review;
    }
}
