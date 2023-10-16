public class User {
    
    private static int id = 001;
    private String password;
    private byte roles;
    private double balance = 0;
    private String converter;

    public User(byte roles) {
        id++;
        switch (roles) {
            case 1:
                this.converter = "Customer";
                break;
            case 2:
                this.converter = "Vendor";
                break;
            case 3:
                this.converter = "Delivery Runner";
                break;
            case 4:
                this.converter = "Administrator";
                break;
        }
    }

    public static int getId() {
        return id;
    }
    public void setPass(String password){
        this.password = password;
    }
    public String getPass(){
        return password;
    }
    public void addBal(double balance){
        this.balance += balance;
    }
    public void setBal(double balance){
        this.balance = balance;
    }
    public double getBal(){
        return balance;
    }
    
    public void setRoles(byte roles){
        this.roles = roles;
        switch (roles) {
            case 1:
                this.converter = "Customer";
                break;
            case 2:
                this.converter = "Vendor";
                break;
            case 3:
                this.converter = "Delivery Runner";
                break;
            case 4:
                this.converter = "Administrator";
                break;
        }
    }
    
    public String getRoles(){
        return converter;
    }
}
