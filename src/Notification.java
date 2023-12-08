public class Notification implements DataProvider {

    private Messages message, messageRunner;
    private String userID, id, orderID; //id here will be used as notification ID when top up, runner ID when delivering
    private String receiptID, date, time, type;
    private int topupamount;
    private String orderID;

    public Notification(Customer customer, String orderID) { //When order is newly created insert the orderID, customer gui HAVE to set messageRunner to SEARCHING when placing delivering order
        Time time = new Time();
        this.time = time.toString();
        message = message.ORDER;
        userID = customer.getId();
        this.orderID = orderID;
    }
    
    public Notification(String id, String receiptID, String  userID, String date, String time, String type, int topupamount){ //Top up notification
        this.id = id;
        this.receiptID = receiptID;
        this.userID = userID;
        this.date = date;
        this.time = time;
        this.date = date;
        this.topupamount = topupamount;
        this.type = type;
    }

    public enum Messages { //Constants will be final so enums can be public
        
        ORDER("You have an incoming order"), //Customer set 
        PREPARE("Your food is being prepared"), //Vendor set
        READY("Your food is ready"), //Vendor set 
        CANCEL("The order has been canceled"), //Customer or vendor set 
        SEARCHING("Searching for delivery runner"), //Runner set 
        UNAVAILABLE("There are no available runner, please choose either dine-in or take-away"), //Customer set 
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
    
    @Override
    public String getId(){
        return id;
    }
    
    public String getOrderID() {
        return orderID;
    }

    public String getMessage() {
        return message.toString();
    }

    public void setMessage(Messages message) {
        Time time = new Time();
        this.time = time.toString();
        this.message = message;
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
