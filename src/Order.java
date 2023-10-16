public class Order {
    private static int id;
    private String converter;
    private byte status;

    public Order() {

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
}
