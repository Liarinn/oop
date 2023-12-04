package laboratory3.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import laboratory3.interf.Stack;

public class ArrayStack<T> implements Stack<T>{
    private int top;
    private static final int capacity = 5;
    private T[] stackelem;
    public ArrayStack(){
        top =-1;
        stackelem = (T[]) new Object[capacity];
    }
    @Override
    public boolean isEmpty(){
        return top == -1;
    }
    @Override
    public boolean isFull(){
        return top == capacity-1;
    }
    @Override
    public boolean push(T item){
        if(isFull()){
            return false;
        }
        stackelem[++top] = item;
        return true;
    }
    @Override
    public T pop(){
        if(isEmpty()){
           return null;
        }
        return stackelem[top--];
    }
    @Override
    public T peek(){
        if(isEmpty()){
            return null;
        }
        return stackelem[top];
    }



}