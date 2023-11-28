import java.util.ArrayList;
import java.util.List;

public class Order implements DataProvider {

    private String id;
    private Status status;
    private String review;
    private String food;
    private double total;
    private String vendorName;
    private String vendorId;
    private Customer customer;
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
        id = "O" + TextEditor.orderIDGenerator(); //Order ID starts with an "O" letter
        status = Status.PENDING;
        Time time = new Time();
        this.time = time;
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.customer = customer;
        this.food = food;
        total = foodCost;
    }
    
    public String getId() {
        return id;
    }

    public void setReview(String review) { //Review should only be set when food status is done or delivered
        this.review = review;
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

    public int getOrderDay() {
        return time.getDay();
    }
    
    public int getOrderMonth() {
        return time.getMonth();
    }
    
    public int getOrderYear() {
        return time.getYear();
    }
    
    public String getTime() {
        return time.toString();
    }

    public Customer getCustomer() { //Getter for delivery order child class usage
        return customer;
    }
    
    public void payment() {
        customer.deductBal(total);
        TextEditor reader = new TextEditor();
        
        List<Object> container = new ArrayList(reader.fileReader(TextEditor.FilePaths.USER));
        for (Object obj : container) { //Adds profit to the vendor object
            Vendor vendor = (Vendor) obj;
            if (vendor.getId().equals(vendorId)) {
                vendor.addProfit(total);
                reader.textDelete(TextEditor.FilePaths.USER, vendor);
                reader.fileWrite(TextEditor.FilePaths.USER, vendor); //Rewrite it all back
                break; //Break out of the loop once done since payment is only given to one vendor per order
            }
        }
    }

    public void setStatus(Status status) { //For vendor and customer to set statuses
        this.status = status;
    }
    
    public String getStatus(){
        return String.valueOf(status);
    }
    
    public String getAddress() {
        return customer.getAddress();
    }
    
    public String getCustomerID() {
        return customer.getId();
    }
    
    public void setTime() {
        Time time = new Time();
        this.time = time;
    }
    
    public String getReview() {
        return review;
    }
    
    public double getTotal() {
        return total;
    }
}
