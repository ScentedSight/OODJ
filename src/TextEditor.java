import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextEditor {

    public TextEditor() {

    }

    public enum FilePaths { //Constants will be final so enum can be public

        USER("C:\\Users\\Johan\\Desktop\\USERS.txt"),
        NOTIFICATION("C:\\Users\\Johan\\Desktop\\NOTIFICATION.txt"),
        MENU("C:\\Users\\Johan\\Desktop\\MENU.txt"),
        HISTORY("C:\\Users\\Johan\\Desktop\\HISTORY.txt");

        private String filePath;

        FilePaths(String filePath) { //Constructor for enum class
            this.filePath = filePath;
        }

        public String getFilePath(){
            return filePath;
        }
    }
    
    public static void fileWrite(FilePaths paths, DataProvider data) { //Any objects implementing DataProvider can be passed to this method
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
                    System.out.println("An error has occurred.");
                }
            }

        } catch (IOException e) {
            System.out.println("An error has occurred while creating the file.");
        }
    }

    public static List<DataProvider> fileReader(FilePaths paths) { //Read objects from text files, returns DataProvider type array
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

        } catch (IOException e) {
            System.out.println("Database file not found or empty records!");
        } catch (ClassNotFoundException e) {
            System.out.println("Mismatch serializable ID in the database file!");
        }

        return container;
    }


    public static void textDelete(FilePaths paths, DataProvider data) { //Deleting a line of object in any textfile based on the ID
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
            System.out.println("An error has occurred.");
        }
    }
    
    public static String idGenerator(FilePaths paths) { //To create a consequent order ID making sure it is unique based on the amount of existing orders in the textfile
        List<Object> container = new ArrayList<>(fileReader(paths));
        int counter = container.size() + 1;
        return String.valueOf(counter);
    }
}
