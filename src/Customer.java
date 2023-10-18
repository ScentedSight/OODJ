public class Customer extends User{

    private static int id = 001;
    private int customerId;
    private double balance = 0;

    public Customer(){
        id++;
        customerId = id;
    }

    public int getId(){
        return customerId;
    }

    public double getBal(){
        return balance;
    }

    public void deductBal(Food food){
        this.balance = balance - food.getCost();
    }

    @Override
    public String toString() {
        return "C" + customerId;
    }
}
