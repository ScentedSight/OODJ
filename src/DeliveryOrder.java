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
        return runner.getId();
    }
    
    public Status getStatusRunner() {
        return statusRunner;
    }
    
    public void setRunnerStatus(Status status) {
        statusRunner = status;
    }
    
    public double getFee() {
        return deliveryFee;
    }
    
    @Override
    public void payment() {
        super.getCustomer().deductBal(super.getCost()); //Deduct customer's balance
        runner.addBal(deliveryFee); //Pay runner
        
        TextEditor reader = new TextEditor();
        List<Object> container = new ArrayList(reader.fileReader(TextEditor.FilePaths.USER));
        for (Object obj : container) { //Adds profit to the vendor object
            Vendor vendor = (Vendor) obj;
            if (vendor.getId().equals(super.getVendorID())) {
                vendor.addProfit(super.getCost() - deliveryFee);
                reader.textDelete(TextEditor.FilePaths.USER, vendor);
                reader.fileWrite(TextEditor.FilePaths.USER, vendor); //Rewrite it all back
                break; //Break out of the loop once done since payment is only given to one vendor per order
            }
        }
    }
}
