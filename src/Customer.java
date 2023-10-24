public class Customer extends User{

    private static int id = 1;
    private String customerId;
    private double balance = 0;
    private String address;

    public Customer(){ //For logging in purpose, attributes will be filled from TextFiles

    }

    public Customer(String password, String address){ //Only for registration, passing password parameter back into inherited attribute
        super(password);
        this.address = address;
        customerId = Integer.toString(id);
        id++;
    }

    public String getId(){ //For retrieving Id in ordering process
        return customerId;
    }

    public void setId(String customerId){ //Inserting the Id back into the newly created Customer object when the Id handler is found in TextFile during the log-in process
        this.customerId = customerId;
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
    public String toString() { //For writing to TextFile during registration
        return "C" + customerId + "," + super.getPass() + "," + address + "," + balance;
    }
}
