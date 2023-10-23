public class Notification { //Incomplete

    private String notification;
    private User user;

    public Notification(String notification, User user) {

    }

    public String getUser() {
        return user.getId();
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }
}
