import java.util.*;

public class MyGraph<T> {

    Node<T> head;

    public class Node<T> {
        List<Node<T>> verticles;
        Boolean visited;
        T value;

        public Node(T value) {
            this.verticles = new ArrayList<>();
            this.visited = false;
            this.value = value;
        }

        public void addVerticle(Node<T> verticle) {
            this.verticles.add(verticle);
        }
    }

    public MyGraph() {

    }

    public void convertArraytoGraph(T[] array) {
        int mid = array.length / 2;

        head = new Node<T>(array[mid]);
        Node<T> current = head;
        for (int i = mid - 1; i >= 0; i--) {
            Node<T> node = new Node<T>(array[i]);
            current.addVerticle(node);
            current = node;
        }
        current = head;
        for (int i = mid + 1; i < array.length; i++) {
            Node<T> node = new Node<T>(array[i]);
            current.addVerticle(node);
            current = node;
        }
    }

    public void printDFS(Node<T> node) {

        if (node.visited) {
            return;
        } else {
            System.out.println(node.value.toString());
            node.visited = true;
            for (Node<T> child : node.verticles) {
                printDFS(child);
            }
        }
    }

    public void printBFS(Node<T> node) {

        LinkedList<Node<T>> nextToBeVisited = new LinkedList<>();

        nextToBeVisited.add(node);
        System.out.println(node.value);

        while (nextToBeVisited.size() > 0) {
            Node<T> actualNode = nextToBeVisited.remove();
            for (int i = 0; i < actualNode.verticles.size(); i++) {
                System.out.println(actualNode.verticles.get(i).value);
            }
            nextToBeVisited.addAll(actualNode.verticles);
        }
    }

    public static void main(String[] args) {

        Integer[] array = {1, 2, 3, 7, 4, 5, 6};

        MyGraph<Integer> graph = new MyGraph<Integer>();

        graph.convertArraytoGraph(array);

        //graph.printDFS(graph.head);
        graph.printBFS(graph.head);

    }
}
