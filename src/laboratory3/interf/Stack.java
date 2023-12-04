package laboratory3.interf;

public interface Stack<T> {
    boolean isEmpty();
    boolean isFull();
    boolean push(T item);
    T pop();
    T peek();

}