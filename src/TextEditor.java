import org.w3c.dom.Text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextEditor {

    public TextEditor() {

    }

    public enum FilePaths {

        USER("path = USERS.txt"),
        MENU("path = MENU.txt"),
        HISTORY("path = HISTORY.txt");

        private String filePath;

        FilePaths(String filePath) { //Constructor for enum class
            this.filePath = filePath;
        }

        public String getFilePath(){
            return filePath;
        }
    }

    public void fileWrite(FilePaths paths, DataProvider dataProvider) {
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
                    FileWriter writer = new FileWriter(paths.name(), true); //Append mode, or else the entire textfile will be overwritten
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

    public List<String> fileReader(FilePaths paths, DataProvider IdProvider) { //Used for any file-reading process, including reading before delete or update functions, returns general List<> which can be transformed into any implementations for output
        List<String> lines = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(paths.getFilePath()));
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] delimiter = currentLine.split(",");
                if (delimiter[0].contains(IdProvider.getId())) {
                    lines.add(currentLine);
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void textEdit(FilePaths paths, DataProvider IdProvider) { //Incomplete
        List<String> content = new ArrayList<>(fileReader(paths, IdProvider));
        //Use [content] to edit elements extracted from user/menu text file for vendor's and admin's update function
        textAppend(paths.getFilePath(), content); //Call class's internal function to rewrite edited text back
    }

    public void textDelete(FilePaths paths, DataProvider IdProvider) { //Incomplete
        List<String> content = new ArrayList<>(fileReader(paths, IdProvider));
        //Use [content] to delete needed elements extracted from user/menu text file for vendor's and admin's delete function
        textAppend(paths.getFilePath(), content); //Call class's internal function to write text back without the deleted part
    }

    private void textAppend(String paths, List<String> lines) { //Class's internal function for editing textfile's line
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(paths));
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
