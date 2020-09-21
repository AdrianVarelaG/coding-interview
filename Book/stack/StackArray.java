package stack;

public class StackArray<T> {
    
    Integer[] sizes;
    T[] value;
    Integer stackSize;
    Integer numberStack;

    public StackArray(final Integer stackSize, final Integer numberStack){
        this.stackSize = stackSize;
        this.numberStack = numberStack;
        this.sizes = new Integer[this.numberStack];
        this.value = (T[]) new Object[this.stackSize * this.numberStack];
    }

}