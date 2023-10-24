public interface DataProvider {
    String getId(); //Setting getId as the highest abstract method so that food/order's object along with user's child class can be unified to pass to one single fileReader method in TextEditor in order to search for specific strings in textpad
    String toString(); //Setting toString as the highest abstract method so that food/order's object can be unified along with user's child class to create only one fileWrite method in TextEditor that is able to accept any child class of this super class
}
