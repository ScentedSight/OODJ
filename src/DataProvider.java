public interface DataProvider {
    String toString(); //Setting toString as the highest abstract method so that food/order's objects can be unified along with user's child class to create only one fileWrite method in TextEditor that is able to accept any child class of this super class
}
