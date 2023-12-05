package laboratory3.queue;

import laboratory3.interf.Queue;

import java.util.NoSuchElementException;

public class CirculaQueueLinkedList<T> implements Queue<T> {
    private Node rear;
    private int size;
    private static final int capacity = 5;

    public class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    public CirculaQueueLinkedList(){
        this.rear = rear;
        size = 0;
        if (this.rear != null) {
            this.rear.next = this.rear;
        }
    }
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    @Override
    public boolean isFull(){
        return size == capacity;
    }
    @Override
    public boolean enqueue (T data) {
        if(isFull()){
            return false;
        }
        Node n = new Node(data);
        if (rear == null) {
            n.next = n;
        } else {
            n.next = rear.next;
            rear.next = n;
        }
        size++;
        rear = n;
        return true;
    }
    @Override
    public T dequeue () {
        if (rear == null)
            return null;
        T temp = rear.next.data;
        if (rear.next == rear)
            rear = null;
        else
            rear.next = rear.next.next;
        size--;
        return temp;
    }
    @Override
    public T peek () {
        if (rear == null)
            return null;
        return rear.next.data;
    }

}
