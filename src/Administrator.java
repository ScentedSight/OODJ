public class Administrator extends User {
    private String id, password;
    private double balance;

    public Administrator(){
        this.id = "A1";
        this.password = "admin123";
    }
    
    public Administrator(String id, String password){
        this.id = id;
        this.password = password;
    }
    
    public String getid(){
        return id;
    }
    
    public void setid(String id){
        this.id = id;
    }
    
    public  double getbal(){
        return balance;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void addBal(double amount){
        balance = balance + amount;
    }

    public void setBal(double amount){
        this.balance = amount;
    }
}