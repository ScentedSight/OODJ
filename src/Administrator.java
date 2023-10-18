public class Administrator extends User{

    private static int id = 001;
    private int administratorId;

    public Administrator(){
        id++;
        administratorId = id;
    }

    public int getId(){
        return administratorId;
    }

    public static void addBal(double amount){

    }

    public static void setBal(double amount){

    }

    @Override
    public String toString() {
        return "A" + administratorId;
    }
}
