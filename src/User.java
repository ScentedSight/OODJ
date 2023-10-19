public class User implements DataProvider {
    
    private int id;
    private String password;

    public User(){

    }

    public User(int id, String password) {
        this.id = id;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setPass(String password){
        this.password = password;
    }

    public String getPass(){
        return password;
    }

    @Override
    public String toString() {
        return id + "," + password;
    }
}
