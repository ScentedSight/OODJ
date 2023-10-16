public class User {
    private static int userID;
    private String password;
    private byte roles;
    private int balance;
    private String role_converter;

    public User() {

        switch (roles) {
            case 1:
                this.role_converter = "Customer";
            case 2:
                this.role_converter = "Vendor";
            case 3:
                this.role_converter = "Delivery Runner";
            case 4:
                this.role_converter = "Administrator";
        }
    }
}
