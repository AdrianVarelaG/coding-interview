package stack;

public class MyStackWithSize<T> extends MyStack<T> {

    private int size;

    public MyStackWithSize() {
        this.size = 0;
    }

    public void push(T value) {
        this.size ++;
        super.push(value);
    }
    public T pop() {
        this.size--;
        return super.pop();
    }

    public int size(){
        return this.size;
    }
    
}