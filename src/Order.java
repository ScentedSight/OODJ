public class Order implements DataProvider {

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
        total = food.getCost();
    }

    public Order(Vendor vendor, Customer customer, Food food, DeliveryRunner runner) {
        Time time = new Time();
        this.time = time;
        total = food.getCost() + deliveryFee;
    }
    
    public String getId(){
        return vendor.getId() + ":" + customer.getId() + ":" + (runner != null ? runner.getId() : "");
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
        return vendor.getId() + ":" + customer.getId() + ":" + (runner != null ? runner.getId() : "") + "," + food.getId() + "," + food.getName() + "," + total + "," + time + "," + status + "," + review;
    }
}
