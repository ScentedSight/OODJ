public class Order {
    
    private static int id = 001;
    private String review;
    private User user;
    private Food food;
    private Time time;

    enum Status{
        PREPARING,
        READY,
        CANCELED,
        DELIVERING,
        DELIVERED
    }

    public Order(User user, Food food) {
        Time time = new Time();
        this.time = time;
        id++;
    }
    
    public int getId(){
        return id;
    }

    public void setReview(String review){
        this.review = review;
    }

    public String getReview(){
        return review;
    }
    
    public int getUser(){
        return user.getId();
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
        return id + "," + user.getId()+ "," + food.getId()+ "," + food.getCost()+ "," + time + review;
    }
}
