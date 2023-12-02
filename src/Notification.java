public class Notification { //Incomplete

    private String message;
    private String userID;
    private String receiptID, date, time, type;
    private double topupamount;

    public Notification(Messages message, User user) { //For general notification
        this.message = message.getMessages();
        userID = user.getId();
    }
    
    public Notification(String receiptID, String  userID, String date, String time, String type, double topupamount){
        this.receiptID = receiptID;
        this.userID = userID;
        this.date = date;
        this.time = time;
        this.date = date;
        this.topupamount = topupamount;
        this.type = type;
    }

    public enum Messages {
        
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserID() {
        return userID;
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

    public double getTopupamount() {
        return topupamount;
    }

    public void setTopupamount(double topupamount) {
        this.topupamount = topupamount;
    }

}
