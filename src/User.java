public abstract class User implements DataProvider {

    //User class mainly used for logging in
    private String id;
    private String password;

    public User(){ //Default constructor for inheritance

    }

    public User(String id, String password) { //Input id and password when logging in
        this.id = id;
        this.password = password;
    }

    public User(String password){ //Input password for registering as Id are assigned on specific user classes
        this.password = password;
    }

    public String getId() { //Not used due to individual users having their own specific Id assignment, this is for implementing DataProvider as all getId methods in-use are child's class of User
        return id;
    }

    public void setPass(String password){ //Parent's class method
        this.password = password;
    }

    public String getPass(){ //Parent's class method
        return password;
    }
}
