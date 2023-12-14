import java.util.ArrayList;
import java.util.List;

public class DeliveryOrder extends Order{
    
    private DeliveryRunner runner;
    private double deliveryFee = 2.50; //Delivery is for within campus only, thus distance and delivery fee are fixed
    private Status statusRunner;
    
    public DeliveryOrder(String vendorId, String vendorName, Customer customer, String food, double foodCost) {
        super(vendorId, vendorName, customer, food, foodCost);
        super.setCost(foodCost + deliveryFee);
        statusRunner = Status.SEARCHING; //Set status so that runner frame code can read orders for deliveries, if order (status = canceled *MUST* statusRunner = canceled)
    }
    
    public void setRunner (DeliveryRunner runner) { //To set designated runner after found
        this.runner = runner;
    }
    
    public String getRunner() {
        if (runner != null) {
            return runner.getId();
        }
        return null;
    }
    
    public String getStatusRunner() {
        return String.valueOf(statusRunner);
    }
    
    public void setRunnerStatus(Status status) {
        statusRunner = status;
    }
    
    public double getFee() {
        return deliveryFee;
    }
    
    @Override
    public void payment(Customer customer) {
        super.payment(customer); //Call Order's payment method to deduct customer's balance and add to vendor's balance
        runner.addBal(deliveryFee); //Pay runner
        
        List<Object> container = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.USER));
        for (Object obj : container) { //Adds profit to the vendor object
            if (obj instanceof Vendor) {
                Vendor vendor = (Vendor) obj;
                if (vendor.getId().equals(super.getVendorID())) {
                    vendor.addProfit(super.getCost() - deliveryFee);
                    TextEditor.textDelete(TextEditor.FilePaths.USER, vendor);
                    TextEditor.fileWrite(TextEditor.FilePaths.USER, vendor); //Rewrite it all back
                    break; //Break out of the loop once done since payment is only given to one vendor per order
                }
            }
        }
    }
    
    @Override
    public void refund(String customerID) {
        List<Object> container = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.USER));
        for (Object obj : container) { //Adds profit to the vendor object
            if (obj instanceof Vendor) {
                Vendor vendor = (Vendor) obj;
                if (vendor.getId().equals(super.getVendorID())) {
                    vendor.refund(super.getCost() - deliveryFee);
                    TextEditor.textDelete(TextEditor.FilePaths.USER, vendor);
                    TextEditor.fileWrite(TextEditor.FilePaths.USER, vendor); //Rewrite it all back
                }
            } else if (obj instanceof Customer) {
                Customer customer = (Customer) obj;
                if (customer.getId().equals(customerID)) {
                    customer.addBal(super.getCost() - deliveryFee);
                    TextEditor.textDelete(TextEditor.FilePaths.USER, customer);
                    TextEditor.fileWrite(TextEditor.FilePaths.USER, customer); //Rewrite the changed balance back
                }
            }
        }
    }
}
