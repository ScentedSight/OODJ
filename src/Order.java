public class Order {
    
    private static int id = 001;
    private int orderId;
    private String review;
    private Customer customer;
    private Food food;
    private Time time;

    enum Status{
        PREPARING,
        READY,
        CANCELED,
        DELIVERING,
        DELIVERED
    }

    public Order(Customer customer, Food food) {
        Time time = new Time();
        this.time = time;
        id++;
        orderId = id;
    }
    
    public int getId(){
        return orderId;
    }

    public void setReview(String review){
        this.review = review;
    }

    public String getReview(){
        return review;
    }
    
    public int getCustomer(){
        return customer.getId();
    }
    
    public String getFood(){
        return food.getName();
    }
    
    public void deductBal(){

    }

    public String getTime(){
        return time.toString();
    }

    @Override
    public String toString() {
        return orderId + "," + customer.getId()+ "," + food.getId()+ "," + food.getCost()+ "," + time + "," + review;
    }
}
