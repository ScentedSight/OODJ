public class Administrator extends User {
    private String id, password;
    private double balance;

    public Administrator(){
        this.id = "A1";
        this.password = "admin123";
    }
    
    public String getid(){
        return id;
    }
    
    public  double getbal(){
        return balance;
    }
    
    @Override
    public String getPass(){
        return password;
    }
    
    public void addBal(double amount){
        balance = balance + amount;
    }

    public void setBal(double amount){
        this.balance = amount;
    }
}
