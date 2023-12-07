public class Review {
    private Order order;
    private Food food;
    private int rating;
    private String comment;
            
    public Review(Order order, int rating, String comment) {
        this.order = order;
        this.rating = rating;
        this.comment = comment;
    }

    public String getOrderId() {
        return order.getId();
    }

    public String getFood() {
        return food.getDescription();
    }

    public double getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComments(String comments) {
        this.comment = comment;
    }

}