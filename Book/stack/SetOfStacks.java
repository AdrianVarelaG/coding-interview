package stack;

import java.util.ArrayList;
import java.util.List;


public class SetOfStacks<T>  {
    private List<MyStackWithSize<T>> stacks;
    private int threshold;

    public SetOfStacks(int threshold) {
        this.threshold = threshold;
        this.stacks = new ArrayList<>();
    }

    public void push(T value) {
        MyStackWithSize<T> stack = selectPushStack();
        stack.push(value);
    }
    public T pop() {
        return popAt(this.stacks.size()-1);
    }

    public T popAt(int index) throws IndexOutOfBoundsException {
        MyStackWithSize<T> stack = this.stacks.get(index);
        T value = stack.pop();
        if(stack.isEmpty())
            this.stacks.remove(index);
        return value;
    }

    private MyStackWithSize<T> selectPushStack() {
        if(stacks.isEmpty()) 
            return addNewStack();
        MyStackWithSize<T> stack = this.stacks.get(this.stacks.size()-1);
        if(stack.size() < this.threshold)
            return stack;
        return addNewStack();
    }

    private MyStackWithSize<T> addNewStack(){
        MyStackWithSize<T> stack = new MyStackWithSize<>();
        this.stacks.add(stack);
        return stack;
    }

}