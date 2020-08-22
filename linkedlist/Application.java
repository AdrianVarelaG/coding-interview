package linkedlist;

public class Application {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("abc");
        list.addFirst("def");
        list.addFirst("ghi");
        System.out.println(list.toString());

        while(list.getSize() > 0) {
            String s = list.removeFirst();
            System.out.println("value: " + s + " : " + list.toString());
        }
        


    }
}