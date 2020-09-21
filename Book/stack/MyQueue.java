package stack;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        private QueueNode( T data){
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T t) {
        QueueNode<T> node = new QueueNode<>(t);

        if(first == null) {
            first = node;
        }else {
            last.next = node;
        }
        last = node;
    }
    public T remove() {
        if(first == null) throw new NoSuchElementException();
        if(first == last) 
            last = null;
        T t = first.data;
        first = first.next;
        return t;
    }

    public T peek() {
        if(first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty(){
        return first == null;
    }

}