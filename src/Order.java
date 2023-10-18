public class Order {
    
    private static int id = 001;
    private int orderId;
    private String review;
    private Vendor vendor;
    private DeliveryRunner runner;
    private Customer customer;
    private Food food;
    private Time time;

    enum Status{
        PREPARING,
        READY,
        CANCELED,
        DELIVERING,
        DELIVERED
    }

    public Order(Vendor vendor, Customer customer, Food food) {
        Time time = new Time();
        this.time = time;
        id++;
        orderId = id;
    }

    public Order(Vendor vendor, Customer customer, Food food, DeliveryRunner runner) {
        Time time = new Time();
        this.time = time;
        id++;
        orderId = id;
    }
    
    public int getId(){
        return orderId;
    }

    public void setReview(String review){
        this.review = review;
    }

    public String getReview(){
        return review;
    }
    
    public int getCustomer(){
        return customer.getId();
    }
    
    public String getFood(){
        return food.getName();
    }

    public String getTime(){
        return time.toString();
    }

    public void payment(){
        customer.deductBal(food);
    }

    public void vendorProfit(){
        vendor.addBal(food);
    }

    public void runnerProfit(){
        runner.addBal();
    }

    @Override
    public String toString() {
        return orderId + "," + customer.getId()+ "," + food.getId()+ "," + food.getCost()+ "," + time + "," + review;
    }
}
