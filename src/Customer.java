public class Customer extends User{

    private double balance = 0;
    private String address;

    public Customer(){
        
    }
    
    public Customer (String id, String password) { //Log in
        super(id, password);
    }

    public Customer (String id, String email, String phoneNo, String gender, String address, String password, double balance) { //Registration
        super(id, email, phoneNo, gender, password);
        this.address = address;
    }

    public String getId(){ //For retrieving Id in ordering process
        return super.getId();
    }

    public void setBal(String balance){ //Inserting the balance back into the newly created Customer object when the Id handler is found in TextFile during the log-in process
        this.balance = Double.parseDouble(balance);
    }

    public void deductBal(double payment){ //Deducting balance from payment of foods
        balance = balance - payment;
    }
    
    public double getBal(){
        return balance;
    }
    
    public String getAddress(){ //Retrieve address for ordering processes
        return address;
    }

    public void setAddress(String address){ //Change address, Admin's function
        this.address = address;
    }
}
