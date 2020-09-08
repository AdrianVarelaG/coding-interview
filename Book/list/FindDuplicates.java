package list;

import list.Node;
import java.util.Map;
import java.util.HashMap;

public class FindDuplicates {
    public static void main(String[] args) {
        FindDuplicates fd = new FindDuplicates();
        Integer[] data = {6,2,3,4,5,6,5,8,3};
        Node<Integer> unsorted = Node.FromArray(data);
        System.out.println(unsorted.toString());
        System.out.println(fd.removeDupsNo(unsorted).toString());
    }

    public Node<Integer> removeDups(Node<Integer> list) {
        Map<Integer, Boolean> exist = new HashMap<>();

        Node<Integer> iterator = list;
        Node<Integer> prev = null;
        while(iterator != null) {
            if(exist.containsKey(iterator.getData())){
                prev.setNext(iterator.getNext());

            }else {
                exist.put(iterator.getData(), true);
                prev = iterator;

            }
            iterator = iterator.getNext();
        }

        return list;
    }

    public Node<Integer> removeDupsNo(Node<Integer> list) {
        Node<Integer> iterator = list;
        Node<Integer> it2;
        Node<Integer> prev;
        while(iterator != null) {
            Integer value = iterator.getData();
            it2 = iterator.getNext();
            prev = iterator;
            while(it2 != null) {
                if(it2.getData().equals(value)){
                    prev.setNext(it2.getNext());
                }else {
                    prev = it2;
                }
                it2 = it2.getNext();
            }
            iterator = iterator.getNext();
        }
        return list;
    }

}