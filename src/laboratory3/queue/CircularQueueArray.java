package laboratory3.queue;

import laboratory3.interf.Queue;

import java.util.Enumeration;

public class CircularQueueArray<T> implements Queue<T> {
    private int front, rear, size;
    private T[] queueElem;
    private static final int queueSize = 2;
    private static final int maxQueueSize = 5;
    public CircularQueueArray() {
        this.front = this.rear = -1;
        queueElem = (T[]) new Object[queueSize];
        size = 0;
    }
    @Override
    public boolean isEmpty(){
        return front == -1;
    }
    @Override
    public boolean isFull(){
        return size == maxQueueSize;
    }
    @Override
    public boolean enqueue(T data) {
        if (isFull())
            return false;
        if (size == queueElem.length)
            resize();
        if (isEmpty())
            front++;
        rear  = (rear+1) % queueElem.length;
        queueElem[rear] = data;
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
            front = (front+1) % queueElem.length;
        return temp;
    }
    @Override
    public T peek () {
        if (isEmpty())
            return null;
        return queueElem[front];
    }
    private void resize () {
        int newSize = queueElem.length*2;;
        if(newSize>maxQueueSize)
            newSize = maxQueueSize;
        T[] tempArr = (T[]) new Object[newSize];
        int i = 0;
        int j = front;
        do {
            tempArr[i++] = queueElem[j];
            j = (j+1) % queueElem.length;
        } while (j != front);
        front = 0;
        rear = queueElem.length-1;
        queueElem = tempArr;
    }
}
