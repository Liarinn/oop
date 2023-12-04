package laboratory3;

import laboratory3.interf.Stack;
import laboratory3.stack.ArrayStack;
import laboratory3.stack.ResizableArrayStack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> arrayStack = new ArrayStack<>();
        Stack<Integer> resizableStack = new ResizableArrayStack<>();


        System.out.println("Perform operations on ArrayStack: \n");
        arrayStack.push(55);
        arrayStack.push(4);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.isFull());
        System.out.println(arrayStack.isEmpty());


        System.out.println("Perform operations on ResizableArrayStack: \n");
        resizableStack.push(7);
        resizableStack.push(9);
        System.out.println(resizableStack.pop());
        System.out.println(resizableStack.isFull());
        System.out.println(resizableStack.isEmpty());
    }
}
