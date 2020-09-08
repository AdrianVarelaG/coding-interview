package list;

import list.Node;

public class KthToLast{
    public static void main(String[] args) {
        KthToLast kl = new KthToLast();
        Integer[] elements = {1,2,3,4,5,6,7,8,9,10};
        Node<Integer> list = Node.FromArray(elements);

        System.out.println(list.toString());
        System.out.println(kl.lastKelements(list, 5).toString());
    }

    public Node<Integer> lastKelements(Node<Integer> list, int n) {
        Node<Integer> fast = list;
        Node<Integer> slow = list;

        while(fast != null) {
            if(n <= 0)
                slow = slow.getNext();
            fast = fast.getNext();
            n--;
        }

        return slow;
    }

}