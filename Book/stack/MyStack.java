package stack;

import java.util.EmptyStackException;

public class MyStack<T> {

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        private StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public void push(T data) {
        StackNode<T> t = new StackNode<T>(data);
        t.next = top;
        top = t;
    }

    public T pop() throws EmptyStackException{
        if(top == null) throw new EmptyStackException();

        T t = top.data;
        top = top.next;

        return t;
    }

    public T peek(){
        if(top == null) throw new EmptyStackException();
        return top.data;
    }
    public boolean isEmpty() {
        return top == null;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        StackNode<T> iterator = top;
        sb.append("[");
        while(iterator != null){
            sb.append(iterator.data.toString());
            iterator = iterator.next;
            if(iterator != null)
                sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }

}