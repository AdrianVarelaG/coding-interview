package linkedlist;

public class LinkedList<T> {

    private Integer size;
    private LinkedList.Node<T> first;
    private LinkedList.Node<T> last;

    public LinkedList(){
        this.size= 0;
        this.first = null;
        this.last = null;
    }

    public Integer getSize(){
        return this.size;
    }

    public void addFirst(T value){
        if(size == 0){
            this.first = new LinkedList.Node<T>(value, null, null);
            this.last = this.first;
        }else {
            LinkedList.Node<T> newNode = new LinkedList.Node<T>(value, null, this.first);
            this.first = newNode;
        }
        this.size++;
    }

    public T removeFirst(){
        if(this.size <= 0) {
            this.size = 0;
            return null;
        }
        LinkedList.Node<T> ret = this.first;
        this.first = this.first.getNext();
        if(this.size == 1)
            this.last = null;
        else
            this.first.setPrev(null);
        this.size--;
        return ret.getValue();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{size: ")
        .append(this.size);

        Node<T> iterator = this.first;
        while(iterator != null){
            sb.append(", ");
            sb.append(iterator.getValue().toString());

            iterator = iterator.getNext();
        }

        sb.append("}");
        return sb.toString();
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> prev;

        public Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
        public Node(T value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }

        public T getValue(){
            return this.value;
        }
        public Node<T> getPrev(){
            return this.prev;
        }
        public Node<T> getNext(){
            return this.next;
        }

        public void setPrev(Node<T> prev){
            this.prev = prev;
        }

    }
}