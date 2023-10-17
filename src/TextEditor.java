import org.w3c.dom.Text;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class TextEditor {

    private User user;
    private Order order;

    public TextEditor(Order order){
        this.order = order;
    }

    public TextEditor(User user){
        this.user = user;
    }

    public void logIn(){

    }
    public void register(){
        try {
            File newUser = new File("UserList.txt");
            if (newUser.createNewFile()) {
                System.out.println("File created: " + newUser.getName());
            } else {
                try {
                    FileWriter writer = new FileWriter("UserList.txt");
                    writer.write(user.toString()+"\n");
                    writer.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void recordOrder(){
        try {
            File newOrder = new File("OrderHistory.txt");
            if (newOrder.createNewFile()) {
                System.out.println("File created: " + newOrder.getName());
            } else {
                try {
                    FileWriter writer = new FileWriter("OrderHistory.txt");
                    writer.write(order.toString()+"\n");
                    writer.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
