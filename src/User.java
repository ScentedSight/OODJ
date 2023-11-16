public abstract class User implements DataProvider{

    private String id;
    private String password;

    public User() { //Default constructor for inheritance

    }

    public User(String id, String password) { //For registering users & Log-in
        this.id = id;
        this.password = password;
    }

    public String getId() { //Used for writing to text file in child class toString methods and other various id retrieval functions
        return id;
    }

    public void setId(String id) { //Inserting the Id back into the newly created child objects when the Id handler is found in TextFile during the log-in process
        this.id = id;
    }

    public String getPass(){ //Parent's class method to provide password for writing to file in child class toString method
        return password;
    }

    public void setPass(String password) { //To set password for factory methods in child classes
        this.password = password;
    }
}
