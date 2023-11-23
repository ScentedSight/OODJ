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

    public void fileWrite(FilePaths paths, Serializable data) { //Any objects implementing DataProvider can be passed to this method
        try {
            File newFile = new File(paths.getFilePath());

            if (newFile.createNewFile()) { //Checking if there are existing files

                System.out.println("File created: " + newFile.getName());
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(paths.filePath));
                oos.writeObject(data);
                System.out.println("Successfully wrote to the file.");
                oos.close();

            } else {

                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(paths.filePath, true)); //Append mode, or else the entire textfile will be overwritten
                    oos.writeObject(data);
                    System.out.println("Successfully wrote to the file.");
                    oos.close();

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

    public List<Object> fileReader(FilePaths paths) { //Read objects from text files, returns object type array
        List<Object> container = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(paths.getFilePath()))) {
            while (true) {
                try {
                    container.add(ois.readObject());
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

    public void textDelete(String userID) { //Deleting a line of object in user textfile based on the ID set
        List<Object> container = new ArrayList<>(fileReader(FilePaths.USER));
        List<Object> appendContainer = new ArrayList<>();
        for (Object object : container) {
            User user = (User) object;
            if (!user.getId().equals(userID)) {
                appendContainer.add(user);
            }
        }
        textWrite(FilePaths.USER.getFilePath(), appendContainer); //Call class's internal function to rewrite the array back to textfile without the deleted object
    }

    public void textDelete(String userID, String foodName) { //Deleting a line of object in user textfile based on the ID set
        List<Object> container = new ArrayList<>(fileReader(FilePaths.MENU));
        List<Object> appendContainer = new ArrayList<>();
        for (Object object : container) {
            Food food = (Food) object;
            if (food.getVendorID().equals(userID) && !food.getDescription().equals(foodName)) {
                appendContainer.add(food);
            }
        }
        textWrite(FilePaths.MENU.getFilePath(), appendContainer); //Call class's internal function to rewrite the array back to textfile without the deleted object
    }

    private void textWrite(String paths, List<Object> appendContainer) { //Class's internal function for overwriting a textfile, mainly used for rewriting objects back to textfile after deletion
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(paths));
            for (Object object : appendContainer) {
                oos.writeObject(object);
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
