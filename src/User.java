public class User {
    private static int id;
    private String password;
    private byte roles;
    private int balance;
    private String converter;

    public User() {

        switch (roles) {
            case 1:
                this.converter = "Customer";
            case 2:
                this.converter = "Vendor";
            case 3:
                this.converter = "Delivery Runner";
            case 4:
                this.converter = "Administrator";
        }
    }
}
