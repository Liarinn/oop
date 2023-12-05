package laboratory3;

import laboratory3.interf.Queue;
import laboratory3.interf.Stack;
import laboratory3.queue.CirculaQueueLinkedList;
import laboratory3.queue.CircularQueueArray;
import laboratory3.queue.LinearQueueArray;
import laboratory3.stack.ArrayStack;
import laboratory3.stack.LinkedListStack;
import laboratory3.stack.ResizableArrayStack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> arrayStack = new ArrayStack<>();
        Stack<Integer> resizableStack = new ResizableArrayStack<>();
        Stack<Integer> linkedListStack = new LinkedListStack<>();

        Queue<Integer> linearQueue = new LinearQueueArray<>();
        Queue<Integer> circularQueue = new CircularQueueArray<>();
        Queue<Integer> circulaQueueLinkedList = new CirculaQueueLinkedList<>();


        System.out.println("Perform operations on Array Stack:");
        arrayStack.push(55);
        arrayStack.push(4);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.isFull());
        System.out.println(arrayStack.isEmpty() + "\n");

        System.out.println("Perform operations on Resizable Array Stack:");
        resizableStack.push(7);
        resizableStack.push(9);
        System.out.println(resizableStack.pop());
        System.out.println(resizableStack.isFull());
        System.out.println(resizableStack.isEmpty() + "\n");

        System.out.println("Perform operations on Linked List Stack:");
        linkedListStack.push(5);
        linkedListStack.push(43);
        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack.isFull());
        System.out.println(linkedListStack.isEmpty() + "\n");


        System.out.println("Perform operations on Linear Queue Array:");
        linearQueue.enqueue(11);
        linearQueue.enqueue(2);
        System.out.println(linearQueue.peek());
        System.out.println(linearQueue.dequeue());
        System.out.println(linearQueue.dequeue());
        System.out.println(linearQueue.isEmpty());
        System.out.println(linearQueue.isFull() + "\n");

        System.out.println("Perform operations on Circular Array Queue: \n");
        circularQueue.enqueue(17);
        circularQueue.enqueue(16);
        System.out.println(circularQueue.peek());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.isEmpty());
        System.out.println(circularQueue.isFull() + "\n");

        System.out.println("Perform operations on Circular LinkedList Queue: \n");
        circulaQueueLinkedList.enqueue(74);
        circulaQueueLinkedList.enqueue(22);
        System.out.println(circulaQueueLinkedList.peek());
        System.out.println(circulaQueueLinkedList.dequeue());
        System.out.println(circulaQueueLinkedList.dequeue());
        System.out.println(circulaQueueLinkedList.isEmpty());
        System.out.println(circulaQueueLinkedList.isFull());
    }
}
