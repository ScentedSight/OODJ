import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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

    public void fileWrite(FilePaths paths, DataProvider data) { //Any objects implementing DataProvider can be passed to this method
        //How to use:
        //First create an object from the current class TextEditor textEditor = new TextEditor();
        //Second create an object from FilePaths enum and specify paths -> Ex. FilePaths addToMenu = FilePaths.MENU
        //Then this method can be called -> Ex. textEditor.fileWrite(addToMenu, dataProvider)
        try {
            File newFile = new File(paths.getFilePath());

            if (newFile.createNewFile()) {
                System.out.println("File created: " + newFile.getName());
                FileWriter writer = new FileWriter(paths.name());
                writer.write(data.toString()+"\n");
                writer.close();
                System.out.println("Successfully wrote to the file.");

            } else {

                try {
                    FileWriter writer = new FileWriter(paths.name(), true); //Append mode, or else the entire textfile will be overwritten
                    writer.write(data.toString()+"\n");
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

    public List<String> fileReader(FilePaths paths) { //Read lines of text from text files, returns general List<> format
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

    /* SAMPLE CODE
    public List<String> fileReader(FilePaths paths, DataProvider IdProvider) { //mainly for view order history, read reviews, read transaction history, read task history, read users and view revenue dashboard, specifically returns general List<> embedded with user ID from IdProvider which can be transformed into any implementations for output
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
    */

    public void textEdit(FilePaths paths, String id, List<String> lines, byte selection, String content) { //Editing pre-processed list passed from fileReader method
        try {
            switch (selection) {
                case 1 -> {
                    String[] container = lines.get(0).split(",");
                    container[1] = content;
                    String updatedContainer = String.join(",", container);
                    textDelete(paths, id);
                    textAppend(paths.getFilePath(), updatedContainer);
                }
                case 2 -> {
                    String[] container = lines.get(0).split(",");
                    container[2] = content;
                    String updatedContainer = String.join(",", container);
                    textDelete(paths, id);
                    textAppend(paths.getFilePath(), updatedContainer);
                }
                case 3 -> {
                    String[] container = lines.get(0).split(",");
                    container[3] = content;
                    String updatedContainer = String.join(",", container);
                    textDelete(paths, id);
                    textAppend(paths.getFilePath(), updatedContainer);
                }
                case 4 -> {
                    String[] container = lines.get(0).split(",");
                    container[4] = content;
                    String updatedContainer = String.join(",", container);
                    textDelete(paths, id);
                    textAppend(paths.getFilePath(), updatedContainer);
                }
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            System.err.println("Array index is out of bound.");
        }
    }

    /* SAMPLE CODE
    public void textEdit(List<String> lines, String foodID,  byte selection, String content) { //Mainly for editing menu, pass integer selection parameter to edit respective elements delimited by ","
        switch (selection) {
            case 1 -> {
                for (String line : lines) {
                    String[] currentLine = line.split(",");
                    if (currentLine[1].equals(foodID)) {
                        currentLine[2] = content;
                        String updatedLine = String.join(",", currentLine);
                        textDelete(vendor, foodID);
                        textAppend(FilePaths.MENU.getFilePath(), updatedLine);
                    }
                }
            }
            case 2 -> {
                for (String line : lines) {
                    String[] currentLine = line.split(",");
                    if (currentLine[1].equals(foodID)) {
                        currentLine[3] = content;
                        String updatedLine = String.join(",", currentLine);
                        textDelete(vendor, foodID);
                        textAppend(FilePaths.MENU.getFilePath(), updatedLine);
                    }
                }
            }
        }
    }
     */

    public void textDelete(FilePaths paths, String id) { //Deleting a line in user or menu textfile based on the ID set, for menu format is (vendor_ID + : + food_name), user format just plain user ID
        List<String> content = new ArrayList<>(fileReader(paths));
        List<String> newContent = new ArrayList<>();
        for (String currentLine : content) {
            String[] delimiter = currentLine.split(",");
            if (!delimiter[0].equals(id) || !delimiter[1].equals(id)) {
                newContent.add(currentLine);
            }
        }
        textWrite(paths.getFilePath(), newContent); //Call internal function to re-write it back
    }

    private void textAppend(String paths, String lines) { //Class's internal function for appending to a textfile, mainly used for appending line back to textfile after elements manipulation
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(paths, true));
            writer.write(lines);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void textWrite(String paths, List<String> lines) { //Class's internal function for overwriting a textfile, mainly used for rewriting lines back to textfile after list manipulation
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
