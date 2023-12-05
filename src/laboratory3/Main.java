package laboratory3;

import laboratory3.interf.Queue;
import laboratory3.interf.Stack;
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


        System.out.println("Perform operations on ArrayStack:");
        arrayStack.push(55);
        arrayStack.push(4);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.isFull());
        System.out.println(arrayStack.isEmpty() + "\n");

        System.out.println("Perform operations on ResizableArrayStack:");
        resizableStack.push(7);
        resizableStack.push(9);
        System.out.println(resizableStack.pop());
        System.out.println(resizableStack.isFull());
        System.out.println(resizableStack.isEmpty() + "\n");

        System.out.println("Perform operations on LinkedListStack:");
        linkedListStack.push(5);
        linkedListStack.push(43);
        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack.isFull());
        System.out.println(linkedListStack.isEmpty() + "\n");


        System.out.println("Perform operations on LinearQueueArray:");
        linearQueue.enqueue(11);
        linearQueue.enqueue(2);
        System.out.println(linearQueue.peek());
        System.out.println(linearQueue.dequeue());
        System.out.println(linearQueue.dequeue());
        System.out.println(linearQueue.isEmpty());
        System.out.println(linearQueue.isFull());
    }
}
