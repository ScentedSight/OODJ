public class Order implements DataProvider {

    private Status status;
    private String review;
    private String foodName;
    private String foodId; 
    private double total;
    private String vendorName;
    private String vendorId;
    private Customer customer;
    private Time time;

    enum Status {
        PENDING, //Order placed but awaiting confirmation from vendor
        PREPARING, //Preparing food
        READY, //Ready for pickup
        COMPLETED, //Order completed
        CANCELED, //Order canceled by either party
        SEARCHING, //Searching for runner
        DELIVERING, //Runner delivering
        DELIVERED //Runner has delivered
    }
    
    public Order(String vendorId, String vendorName, Customer customer, String foodName, String foodId, double foodCost) {
        status = Status.PENDING;
        Time time = new Time();
        this.time = time;
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.customer = customer;
        this.foodName = foodName;
        this.foodId = foodId;
        total = foodCost;
    }
    
    public String getId() { //Order ID is made of vendor ID + customer ID
        return vendorId + ":" + customer.getId();
    }

    public void setReview(String review) { //Review should only be set when food status is done or delivered
        this.review = "," + review;
    }

    public String getCustomer() {
        return customer.getId();
    }
    
    public String getFood() {
        return foodId;
    }

    public void setCost (double cost) { //For child class to set total cost
        total = cost;
    }
    
    public double getCost() {
        return total;
    }
   
    public String getVendor() {
        return vendorId;
    }

    public String getTime() {
        return time.toString();
    }

    public void payment() {
        customer.deductBal(total);
        //vendor.addBal(total);
    }

    public void setStatus(Status status) { //For vendor and customer to set statuses
        this.status = status;
    }
    
    public String getAddress() {
        return customer.getAddress();
    }
    
    @Override
    public String toString() { //For writing to order history
        return ":" + vendorId + ":" + customer.getId() + "," + vendorName + "," + foodName + "," + foodId + "," + total + "," + time + "," + status + review;
    }
}
