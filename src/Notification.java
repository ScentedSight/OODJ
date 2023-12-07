public class Notification implements DataProvider {

    private Messages message;
    private String userID, id, orderID;
    private String receiptID, date, time, type;
    private int topupamount;

    public Notification(Messages message, User user, String orderID) { //For general notification
        this.message = message;
        userID = user.getId();
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
        
        ORDER("You have an incoming order"),
        PREPARE("Your food is being prepared"),
        READY("Your food is ready"),
        CANCEL("The order has been canceled"),
        SEARCHING("Searching for delivery runner"),
        UNAVAILABLE("There are no available runner, please choose either dine-in or take-away"),
        DELIVERING("Your food is delivering"),
        DELIVERED("Your food has been delivered"),
        RECEIPT("You have successfully topped up ");

        private String messages;

        Messages (String messages) { //Constructor for enum class
            this.messages = messages;
        }

        public String getMessages() {
            return messages;
        }
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
        this.message = message;
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
