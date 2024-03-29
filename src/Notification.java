public class Notification implements DataProvider {

    private Messages message, messageRunner;
    private String userID, id, vendorID, runnerID; //id here will be used as notification ID when top up, order ID when ordering ,
    private String receiptID, date, time, type;
    private int topupamount;
    
    public Notification(String vendorID, Customer customer, String orderID) { //When order is newly created insert the orderID, customer gui HAVE to set messageRunner to SEARCHING when placing delivering order
        Time time = new Time();
        this.time = time.toString();
        message = Messages.ORDER;
        userID = customer.getId();
        this.id = orderID;
        this.vendorID = vendorID;
    }
    
    public Notification(String id, String receiptID, String  userID, String type, int topupamount){ //Top up notification
        message = Messages.RECEIPT;
        Time time = new Time();
        this.time = time.toString();
        date = time.getDay() + "/" +  time.getMonth() + "/" + time.getYear();
        this.id = id;
        this.receiptID = "R" + receiptID;
        this.userID = userID; //Customer's id
        this.topupamount = topupamount;
        this.type = type;
    }

    public enum Messages { //Constants will be final so enums can be public
        
        ORDER("You have an incoming order"), //Customer set 
        PREPARE("Your food is being prepared"), //Vendor set
        READY("Your food is ready"), //Vendor set 
        CANCEL("The order has been canceled"), //Customer or vendor set 
        SEARCHING("Searching for delivery runner"), //Runner set 
        DELIVERING("Your food is delivering"), //Runner set
        DELIVERED("Your food has been delivered"), //Runner set
        RECEIPT("You have successfully topped up "); //Admin set

        private String messages;

        Messages (String messages) { //Constructor for enum class
            this.messages = messages;
        }

        public String getMessages() {
            return messages;
        }
    }
    
    public void setID(String id) {
        this.id = id;
    }
    
    public void setRunnerID (String id) {
        runnerID = id;
    }
    
    public String getRunnerID() {
        return runnerID;
    }
    
    @Override
    public String getId(){
        return id;
    }

    public String getMessage() {
        return message.getMessages();
    }

    public void setMessageBackUp(int changer) { //Using switch case since for some reason Messages enum class cant be referred and passed to the original method in customer's frame
        Time time = new Time();
        this.time = time.toString();
        
        switch (changer) { 
            case 1:
                this.message = Messages.ORDER;
                break;
            case 2:
                this.message = Messages.PREPARE;
                break;
            case 3:
                this.message = Messages.READY;
                break;
            case 4:
                this.message = Messages.CANCEL;
                break;
            case 5:
                this.message = Messages.SEARCHING;
                break;
            case 6:
                this.message = Messages.DELIVERING;
                break;
            case 7:
                this.message = Messages.DELIVERED;
                break;
            case 8:
                this.message = Messages.RECEIPT;
            default:
                throw new IllegalArgumentException("Invalid message value: " + changer);    
        }
    }
    
    public void setMessageRunnerBackUp(int changer) { //Using switch case since for some reason Messages enum class cant be referred and passed to the original method in customer's frame
        Time time = new Time();
        this.time = time.toString();
        
        switch (changer) { 
            case 1:
                this.messageRunner = Messages.ORDER;
                break;
            case 2:
                this.messageRunner = Messages.PREPARE;
                break;
            case 3:
                this.messageRunner = Messages.READY;
                break;
            case 4:
                this.messageRunner = Messages.CANCEL;
                break;
            case 5:
                this.messageRunner = Messages.SEARCHING;
                break;
            case 6:
                this.messageRunner = Messages.DELIVERING;
                break;
            case 7:
                this.messageRunner = Messages.DELIVERED;
                break;
            case 8:
                this.messageRunner = Messages.RECEIPT;
            default:
                throw new IllegalArgumentException("Invalid message value: " + changer);    
        }
    }
    
    public void setMessage(Messages message) {
        Time time = new Time();
        this.time = time.toString();
        this.message = message;
    }
    
    public String getMessageRunner() {
        if (messageRunner != null) {
            return messageRunner.getMessages();
        }
        return null;
    } 
    
    public void setMessageRunner(Messages message) {
        Time time = new Time();
        this.time = time.toString();
        messageRunner = message;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    public String getUser() {
        return userID;
    }
    
    public String getVendorID() {
        return vendorID;
    }
    
    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }
    
    public String getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTopupamount() {
        return topupamount;
    }

    public void setTopupamount(int topupamount) {
        this.topupamount = topupamount;
    }
    
    @Override
    public String toString(){
        return Messages.RECEIPT+ " ,RM "+topupamount+ " on "+date;
    }

}
