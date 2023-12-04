package laboratory3.interf;

public interface Queue<T> {
    boolean isEmpty();
    boolean isFull();
    boolean enqueue(T item);
    T dequeue();
    T peek();
}
