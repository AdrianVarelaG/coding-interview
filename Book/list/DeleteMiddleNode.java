package list;

import list.Node;

public class DeleteMiddleNode {
    public static void main(String[] args) {
        DeleteMiddleNode dmn = new DeleteMiddleNode();

        Character[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        Node<Character> list = Node.FromArray(chars);
        System.out.println(list.toString());

        System.out.println(dmn.deleteElement(list, 'f').toString());
    }

    public Node<Character> deleteElement(Node<Character> list, Character c) {
        Node<Character> head = list;
        if(head.getData().equals(c))
            return head.getNext();
        Node<Character> prev= list;
        list = list.getNext();
        while(list != null) {
            if(list.getData().equals(c)) {
                prev.setNext(list.getNext());
                break;
            }else {
                prev = list;
                list = list.getNext();
            }
        }

        return head;
    }
}