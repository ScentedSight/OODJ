public class Review {
    private Customer customer;
    private Food food;
    private int rating;
    private String comment;
            
    public Review(Customer customer, int rating, String comment) {
        this.customer = customer;
        this.rating = rating;
        this.comment = comment;
    }

    public String getCustomer() {
        return customer.getId();
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