public class Administrator extends User {
    private int id;
    private double balance;

    public Administrator(){
        
    }
    
    public Administrator(int id){
        this.id = id;
    }
    
    public int getid(){
        return id;
    }
    
    public void setid(int id){
        id++;
        this.id = id;
    }
    
    public  double getbal(){
        return balance;
    }
    
    public void addBal(double amount){
        balance = balance + amount;
    }

    public void setBal(double amount){
        this.balance = amount;
    }
}