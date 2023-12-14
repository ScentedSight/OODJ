import java.util.ArrayList;
import java.util.List;

public class Order implements DataProvider {

    private String id;
    private Status status;
    private String review;
    private int ratings;
    private String remark;
    private String food;
    private double total;
    private String vendorName;
    private String vendorId;
    private Customer customer;
    private double quantity;
    Time time;
    

    enum Status {
        //Status Sequence for different order options (ONLY VENDOR CAN SET THESE FOLLOWING STATUSES)

        PENDING, //Order placed but awaiting confirmation from vendor
        PREPARING, //Preparing food, vendor's status
        READY, //Ready for pickup, vendor's status
        PICKED_UP, //Order has picked up, vendor's status
        COMPLETED, //Order completed, vendor's status
        CANCELLED, //Order canceled by either party

        //Dine-in -> Pending, Preparing, Ready, Completed
        //Take-away -> Pending, Preparing, Ready, Picked_Up
        //Delivery -> Pending, Preparing, Ready, Picked_Up

        //Status Sequence for delivery orders (ONLY DELIVERY RUNNER CAN SET THESE FOLLOWING STATUSES)
        SEARCHING, //Searching for runner, runner's status
        DELIVERING, //Runner delivering, runner's status
        DELIVERED; //Runner has delivered, runner's status

        //Delivery runner status (Child class attribute) = Searching, Delivering, Delivered
        
    }
    
    public Order(){}
    
    public Order(String vendorId, String vendorName, Customer customer, String food, double foodCost) {
        id = "O" + TextEditor.idGenerator(TextEditor.FilePaths.HISTORY); //Order ID starts with an "O" letter
        status = Status.PENDING;
        Time time = new Time();
        this.time = time;
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.customer = customer;
        this.food = food;
        total = foodCost;
    }
    public void setId(String id){
        this.id = id;
    }
    
    public String getId() {
        return id;
    }

    public void setReview(String review) { //Review should only be set when food status is done or delivered
        this.review = review;
    }
    public void setFood(String food){
        this.food = food;
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
    
    public void payment(Customer customer) {
        customer.deductBal(total); //Pass customer object since this customer object will be outdated
        TextEditor.textDelete(TextEditor.FilePaths.USER, customer);
        TextEditor.fileWrite(TextEditor.FilePaths.USER, customer); //Rewrite the changed balance back

        List<Object> container = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.USER));
        for (Object obj : container) { //Adds profit to the vendor object
            if (obj instanceof Vendor) {
                Vendor vendor = (Vendor) obj;
                if (vendor.getId().equals(vendorId)) {
                    vendor.addProfit(total);
                    TextEditor.textDelete(TextEditor.FilePaths.USER, vendor);
                    TextEditor.fileWrite(TextEditor.FilePaths.USER, vendor); //Rewrite it all back
                    break; //Break out of the loop to speed up the process
                }
            }
        }
    }
    
    public void refund(String customerID) {
        List<Object> container = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.USER));
        for (Object obj : container) { //Adds profit to the vendor object
            if (obj instanceof Vendor) {
                Vendor vendor = (Vendor) obj;
                if (vendor.getId().equals(vendorId)) {
                    vendor.refund(total);
                    TextEditor.textDelete(TextEditor.FilePaths.USER, vendor);
                    TextEditor.fileWrite(TextEditor.FilePaths.USER, vendor); //Rewrite it all back
                }
            } else if (obj instanceof Customer) {
                Customer customer = (Customer) obj;
                if (customer.getId().equals(customerID)) {
                    customer.addBal(total); //Add balance back to the respective customer
                    TextEditor.textDelete(TextEditor.FilePaths.USER, customer);
                    TextEditor.fileWrite(TextEditor.FilePaths.USER, customer); //Rewrite the changed balance back
                }
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
    
    public void setRatings(int rating) {
        ratings = rating;
    }
    
    public int getRatings(){
        return ratings;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getRemark(){
        return remark;
    }
    
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    
    public double getQuantity(){
        return quantity;
    }
}
