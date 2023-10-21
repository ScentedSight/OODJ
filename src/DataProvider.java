public interface DataProvider {
    String getId(); //Unifying all the getId methods so that you can use it as a handler to search for specific strings in textpad using FileRead method in TextEditor
    String toString(); //Unifying all the toString overrides so that you can pass any objects created from class implementing DataProvider into File Write/Read method in TextEditor
}
