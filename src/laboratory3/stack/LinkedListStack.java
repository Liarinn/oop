package laboratory3.stack;
import laboratory3.interf.Stack;

public class LinkedListStack<T> implements Stack<T> {
    private Node top;
    private int size;
    private static final int capacity = 5;
    private class Node{
        T data;
        private Node next;
        public Node (T data) {
            this.data = data;
            this.next = null;
        }
    }
    public LinkedListStack(){
        top = null;
        size = 0;
    }
    @Override
    public boolean isEmpty() {
        return top == null;
    }
    @Override
    public boolean isFull() {
        return size == capacity;
    }
    @Override
    public boolean push(T item) {
        if(isFull()){
            return false;
        }
        Node tempNode = new Node(item);
        tempNode.next = top;
        top = tempNode;
        size++;
        return true;
    }
    @Override
    public T pop() {
        if(isEmpty()){
            return null;
        }
        T result = top.data;
        top = top.next;
        size--;
        return result;
    }
    @Override
    public T peek() {
        if(isEmpty()) {
            return null;
        }
        return top.data;
    }

//    public void displayStack() {
//        Node current = top;
//
//        while (current != null) {
//            System.out.print(current.data+" ");
//
//            current = current.next;
//        }
//
//    }
}
