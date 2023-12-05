

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextEditor {

    public TextEditor() {

    }

    public enum FilePaths {

        USER("C:\\Users\\110ti\\OneDrive - Asia Pacific University\\Degree Year 2\\Tutorial\\Java\\Assignment\\files\\USERS.txt"),
        NOTIFICATION("C:\\Users\\110ti\\OneDrive - Asia Pacific University\\Degree Year 2\\Tutorial\\Java\\Assignment\\files\\NOTIFICATION.txt"),
        MENU("path = MENU.txt"),
        HISTORY("C:\\Users\\Johan\\Desktop\\HISTORY.txt");

        private String filePath;

        FilePaths(String filePath) { //Constructor for enum class
            this.filePath = filePath;
        }

        public String getFilePath(){
            return filePath;
        }
    }
    
    public void fileWrite(FilePaths paths, DataProvider data) { //Any objects implementing DataProvider can be passed to this method
        try {
            File newFile = new File(paths.getFilePath());

            if (newFile.createNewFile()) { //Checking if there are existing files
                
                System.out.println("File created: " + newFile.getName());
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(paths.filePath));
                oos.writeObject(data);
                System.out.println("Successfully wrote to the file.");
                oos.close();

            } else {

                try { //Append block, or else the entire textfile will be overwritten
                    List<DataProvider> container = fileReader(paths);
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(paths.filePath));
                    for (DataProvider object : container) {
                        oos.writeObject(object);
                    }
                    oos.writeObject(data); // Appending new object after writing from list
                    System.out.println("Successfully wrote to the file.");
                    oos.close();

                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    public List<DataProvider> fileReader(FilePaths paths) { //Read objects from text files, returns DataProvider type array
        List<DataProvider> container = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(paths.getFilePath()))) {
            while (true) {
                try {
                    container.add((DataProvider) ois.readObject());
                } catch (EOFException e) { //Catch EOFException to handle the end of file
                    ois.close();
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return container;
    }


    public void textDelete(FilePaths paths, DataProvider data) { //Deleting a line of object in any textfile based on the ID
        try {
            List<DataProvider> container = new ArrayList<>(fileReader(paths));
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(paths.getFilePath()));
            for (DataProvider objects : container) {
                if (!objects.getId().equals(data.getId())) {
                    oos.writeObject(objects);
                }
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String orderIDGenerator() { //To create a randomized order ID while saving the concurrent ID for every software restarts, static so it can be used without creating the object
        List<DataProvider> container = fileReade;
        int counter = container.size();
    }
}
