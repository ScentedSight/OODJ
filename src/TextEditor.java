import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;

public class TextEditor {

    private User user;
    private Order order;

    public TextEditor(){

    }

    public TextEditor(Order order){
        this.order = order;
    }

    public TextEditor(User user){
        this.user = user;
    }

    public enum FilePaths{

        USERS("path = USERS.txt"),
        HISTORY("path = HISTORY.txt");

        private String filePath;

        FilePaths(String filePath) {
            this.filePath = filePath;
        }

        public String getFilePath(){
            return filePath;
        }
    }

    public void fileReader(FilePaths paths, DataProvider IdProvider){
        //How to use:
        //First create an object from the current class TextEditor textEditor = new TextEditor();
        //Secondly create an object from FilePaths enum and specify paths -> Ex. FilePaths addToHistory = FilePaths.HISTORY
        //Then this method can be called -> Ex. textEditor.fileReader(addToHistory, IdProvider)
        try {
            FileReader reader = new FileReader(paths.getFilePath());
            BufferedReader bufferedReader = new BufferedReader(reader);
            String search = String.valueOf(IdProvider.getId());
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Check if the line contains the specific string
                if (line.contains(search)) {
                    // Desired action
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileWrite(FilePaths paths, DataProvider dataProvider){
        //How to use:
        //First create an object from the current class TextEditor textEditor = new TextEditor();
        //Second create an object from FilePaths enum and specify paths -> Ex. FilePaths addToMenu = FilePaths.MENU
        //Then this method can be called -> Ex. textEditor.fileWrite(addToMenu, dataProvider)
        try {
            File newFile = new File(paths.getFilePath());
            if (newFile.createNewFile()) {
                System.out.println("File created: " + newFile.getName());
                FileWriter writer = new FileWriter(paths.name());
                writer.write(dataProvider.toString()+"\n");
                writer.close();
                System.out.println("Successfully wrote to the file.");
            } else {
                try {
                    FileWriter writer = new FileWriter(paths.name());
                    writer.write(dataProvider.toString()+"\n");
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
