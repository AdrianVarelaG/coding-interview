package stack;

public class MyStackWithMin extends MyStack<NodeWithMin>{

    public static void main(String[] args) {
        MyStackWithMin  stack = new MyStackWithMin();

        stack.push(5);
        System.out.println(stack);
        stack.push(6);
        System.out.println(stack);
        stack.push(3);
        System.out.println(stack);
        stack.push(7);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);

    }


    public void push(int value){
        int minValue = Integer.min(min(), value);

        NodeWithMin node = new NodeWithMin(value, minValue);
        super.push(node);
    }
    
    private Integer min(){
        if(this.isEmpty())
            return Integer.MAX_VALUE;
        else
            return peek().min;
    }

}