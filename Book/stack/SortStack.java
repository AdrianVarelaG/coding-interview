package stack;

public class SortStack {
    private MyStack<Integer> s1;
    private MyStack<Integer> s2;

    public SortStack() {
        this.s1 = new MyStack<>();
        this.s2 = new MyStack<>(); 
    }

    public void push(Integer value) {
        if(s1.isEmpty()){
            s1.push(value);
        } else {
            if(s1.peek() < value) {
                while(!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                s1.push(value);
                while(!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }else {
                s1.push(value);
            }
        }
    }

    public String toString(){
        return "s1: " + s1.toString() + ", s2:" + s2.toString();
    }

    public static void main(String[] args) {
        SortStack ss = new SortStack();

        ss.push(5);
        System.out.println(ss);
        ss.push(6);
        System.out.println(ss);
        ss.push(3);
        System.out.println(ss);
        ss.push(7);
        System.out.println(ss);


    }

}