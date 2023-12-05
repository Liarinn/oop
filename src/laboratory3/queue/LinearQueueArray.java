package laboratory3.queue;
import laboratory3.interf.Queue;

public class LinearQueueArray<T> implements Queue<T> {
    private int front, rear, size;
    private T[] queueElem;
    private static final int capacity = 5;
    public LinearQueueArray() {
        this.front = this.rear = -1;
        queueElem = (T[]) new Object[capacity];
        size = 0;
    }
    @Override
    public boolean isEmpty(){
        return front == -1;
    }
    @Override
    public boolean isFull(){
        return size == capacity;
    }
    @Override
    public boolean enqueue(T data) {
        if (isFull())
            return false;
        if (isEmpty())
            front++;
        queueElem[++rear] = data;
        return true;
    }
    @Override
    public T dequeue() {
        if (isEmpty())
            return null;
        T temp = queueElem[front];
        if (front == rear)
            front = rear = -1;
        else
            front++;
        return temp;
    }
    @Override
    public T peek () {
        if (isEmpty())
            return null;
        return queueElem[front];
    }
}
