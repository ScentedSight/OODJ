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

    public void fileWrite(FilePaths paths, DataProvider dataProvider) { //Any objects implementing DataProvider can be passed to this method
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

    public List<String> fileReader(FilePaths paths) { //Overloaded method for any file-reading process, also can be used for login/registration and view menu while including reading before delete or update functions, returns general List<> format which can be transformed into any implementations for output
        List<String> lines = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(paths.getFilePath()));
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                lines.add(currentLine);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public List<String> fileReader(FilePaths paths, DataProvider IdProvider) { //Overloaded method mainly for view order history, read reviews, read transaction history, read task history, read users and view revenue dashboard, specifically returns general List<> embedded with user ID from IdProvider which can be transformed into any implementations for output
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

    public void textEdit(FilePaths paths, DataProvider IdProvider, int selection, String content) { //Mainly for editing menu and user list
        List<String> contents = new ArrayList<>(fileReader(paths, IdProvider));
        switch (selection) {
            case 0:
            case 1:
            case 2:
            case 3:
        }
        textWrite(paths.getFilePath(), contents); //Call class's internal function to rewrite edited text back
    }

    public void textDelete(DataProvider IdProvider) { //Method overloading for deleting a line in the users text file or used internally in other methods
        List<String> content = new ArrayList<>(fileReader(FilePaths.USER));
        List<String> newContent = new ArrayList<>();
        for (String currentLine : content) {
            String[] delimiter = currentLine.split(",");
            if (!delimiter[0].equals(IdProvider.getId())) {
                newContent.add(currentLine);
            }
        }
        textWrite(FilePaths.USER.getFilePath(), newContent); //Calling class's internal function to rewrite it back
    }

    public void textDelete(Vendor vendor, String foodID) { //Method overloading for deleting a line in the menu text file
        List<String> content = new ArrayList<>(fileReader(FilePaths.MENU));
        List<String> newContent = new ArrayList<>();
        for (String currentLine : content) {
            String[] delimiter = currentLine.split(",");
            while (delimiter[0].equals(vendor.getId())) {
                if (!delimiter[1].equals(foodID)) {
                    newContent.add(currentLine);
                }
            }
        }
        textWrite(FilePaths.MENU.getFilePath(), newContent); //Calling class's internal function to rewrite it back
    }

    private void textAppend(String paths, List<String> lines) { //Class's internal function for appending to a textfile
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

    private void textWrite(String paths, List<String> lines) { //Class's internal function for overwriting a textfile
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
