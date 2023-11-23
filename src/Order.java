import java.io.Serializable;

public class Order implements Serializable {

    private Status status;
    private String review;
    private String food;
    private double total;
    private String vendorName;
    private String vendorId;
    private Customer customer;
    private String customerID;
    private Time time;

    enum Status {
        PENDING, //Order placed but awaiting confirmation from vendor
        PREPARING, //Preparing food, vendor's status
        READY, //Ready for pickup, vendor's status
        COMPLETED, //Order completed, vendor's status
        CANCELED, //Order canceled by either party
        SEARCHING, //Searching for runner, runner's status
        DELIVERING, //Runner delivering, runner's status
        DELIVERED //Runner has delivered, runner's status
    }
    
    public Order(String vendorId, String vendorName, Customer customer, String food, double foodCost) {
        status = Status.PENDING;
        Time time = new Time();
        this.time = time;
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.customer = customer;
        this.food = food;
        customerID = customer.getId();
        total = foodCost;
    }

    public void setReview(String review) { //Review should only be set when food status is done or delivered
        this.review = review;
    }

    public String getCustomer() {
        return customerID;
    }
    
    public String getFood() {
        return food;
    }

    public void setCost (double cost) { //For child class to set total cost
        total = cost;
    }
    
    public double getCost() {
        return total;
    }
   
    public String getVendorID() {
        return vendorId;
    }
    
    public String getVendorName() {
        return vendorName;
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
}
