public class Order {
    
    private static int id = 001;
    private String converter;
    private byte status;
    private String review;
    private User user;
    private Food food;
    private Time time;


    public Order(byte status, User user, Food food) {
        Time time = new Time();
        this.time = time;
        id++;
        switch (status) {
            case 1:
                this.converter = "Preparing";
            case 2:
                this.converter = "Ready";
            case 3:
                this.converter = "Canceled";
            case 4:
                this.converter = "Delivering";
            case 5:
                this.converter = "Delivered";
        }
    }
    
    public int getId(){
        return id;
    }
    
    public void setStatus(byte status){
        this.status = status;
        switch (status) {
            case 1:
                this.converter = "Preparing";
            case 2:
                this.converter = "Ready";
            case 3:
                this.converter = "Canceled";
            case 4:
                this.converter = "Delivering";
            case 5:
                this.converter = "Delivered";
        }
    }
    
    public String getStatus(){
        return converter;
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
    
    public void deductbal(){
        double foodPrice = food.getCost();
        double userBal = user.getBal();
        user.setBal(foodPrice - userBal);
    }

    public String getTime(){
        return time.toString();
    }
}
