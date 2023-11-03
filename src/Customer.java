public class Customer extends User{

    private double balance = 0;
    private String address;

    private Customer() { //Private default constructor to prevent instantiation due to class having factory methods for instantiation

    }

    public static Customer createForLogin(String id, String password){ //Static factory method for login due to same parameter types cant be used in overloading constructor, used like -> Customer customerLogin = Customer.createForLogin("C123", "pass123")
        Customer customer = new Customer();
        customer.setId(id);
        customer.setPass(password);
        return customer;
    }

    public static Customer createForRegistration(String password, String address){ //Static factory method for registration due to same parameter types cant be used in overloading constructor, used like -> Customer customerRegister = Customer.createForRegistration("pass123", "67, Oakland Streets, Portland")
        Customer customer = new Customer();
        customer.setPass(password);
        customer.address = address;
        return customer;
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
        return "C" + super.getId() + "," + super.getPass() + "," + address + "," + balance;
    }
}
