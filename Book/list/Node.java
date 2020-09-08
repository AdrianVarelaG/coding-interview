package list;

public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    public T getData(){
        return this.data;
    }
    public void setNext(Node<T> next){
        this.next = next;
    }
    public Node<T> getNext(){
        return this.next;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<T> iterator = this;

        while(iterator != null){
            sb.append(iterator.data);
            if(iterator.next != null)
                sb.append(" -> ");
            iterator = iterator.next;
        }

        return sb.toString();
    }

    public static <T> Node<T> FromArray(T[] values) {
        Node<T> ret = null;
        Node<T> prev = null;
        for(T value: values) {
            Node<T> n = new Node<>(value);
            if(ret == null){
                ret = n;
                ret.setNext(null);
            }else {
                prev.setNext(n);
            }
            prev = n;
        }

        return ret;
    }
}
