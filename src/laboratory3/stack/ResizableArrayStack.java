package laboratory3.stack;

import laboratory3.interf.Stack;

public class ResizableArrayStack<T> implements Stack<T> {
    private T[] stackObject;
    private int top;
    private static final int stackSize = 2;
    private static final int maxStackSize = 5;

    @SuppressWarnings("unchecked")
    public ResizableArrayStack(){
        top = -1;
        stackObject = (T[]) new Object[stackSize];
    }
    @Override
    public boolean isEmpty() {
        return top == -1;
    }
    @Override
    public boolean isFull(){
        return top == maxStackSize -1;
    }
    @Override
    public T pop() {
        if(isEmpty()){
            return null;
        }
        return stackObject[top--];
    }
    @Override
    public T peek(){
        if(isEmpty()){
            return null;
        }
        return stackObject[top];
    }
    @Override
    public boolean push(T item) {
        if(isFull()){
            return false;
        }
        if (top >= stackSize - 1) {
            resize();
        }
        stackObject[++top] = item;
        return true;
    }
    private void resize() {
        if(stackObject.length < maxStackSize) {
            T[] temp = (T[]) new Object[stackObject.length + 1];
            for (int i = 0; i <= top; i++) {
                stackObject[i] = temp[i];
            }
        }
    }


}
