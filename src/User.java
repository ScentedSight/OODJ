public abstract class User implements DataProvider {
    private String id, email, gender, phoneNo, password, confirm_password;
    
    public User(){

    }
    
    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }
    
    public User(String id, String email, String phoneNo,String gender, String password){
        this.id = id;
        this.email = email;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.password = password;
    }
    
    @Override
    public String getId(){
        return id;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
    
     public void setId(String id){
        this.id = id;
    }

    public void setPhoneNo(String phone_number) {
        this.phoneNo = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getPass(){
        return password;
    }
    
    public void setPass(String password){
        this.password = password;
    }
    
    public void setConfirmPass(String confirm_password){
        this.confirm_password = confirm_password;
    }
    
    public String getConfirmPass(){
        return confirm_password;
    }

}
