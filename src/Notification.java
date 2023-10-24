public class Notification { //Incomplete

    private String message;
    private String userID;

    public Notification(Messages message, User user) { //For general notification
        this.message = message.getMessages();
        userID = user.getId();
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

    public String getUser() {
        return userID;
    }
}
