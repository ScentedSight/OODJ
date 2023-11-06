public class Customer extends User{

    private double balance = 0;
    private String address;

    public Customer (String id, String password) { //Log in
        super(id, password);
    }

    public Customer (String id, String password, String address) { //Registration
        super(id, password);
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

    public String getAddress(){ //Retrieve address for ordering processes
        return address;
    }

    public void setAddress(String address){ //Change address, Admin's function
        this.address = address;
    }

    @Override
    public String toString() { //Format for writing to TextFile during registration
        return "C," + super.getId() + "," + super.getPass() + "," + address + "," + balance;
    }
}
