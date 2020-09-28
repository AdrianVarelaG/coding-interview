package graph;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.HashSet;

public class Graph<T> {
    private static class Node<T> {
        private T value;
        public LinkedList<Node<T>> adjacent;

        private Node(T value) {
            this.value = value;
            this.adjacent = new LinkedList<>();
        }

        public void add(Node<T> node) {
            this.adjacent.add(node);
        }

        public T getValue(){
            return this.value;
        }

        public String toString(){
            StringBuilder sb = new StringBuilder()
            .append(this.value)
            .append(": ");
            Iterator<Node<T>> it = this.adjacent.iterator();
            while(it.hasNext()){
                sb.append(it.next().getValue());
                if(it.hasNext())
                    sb.append(", ");
            }
            return sb.toString();
        }

        private void visitDFS(Consumer<T> visit, HashSet<T> visited) {
            visit.accept(this.value);
            visited.add(this.value);
            Iterator<Node<T>> it = this.adjacent.iterator();
            while(it.hasNext()) {
                Node<T> node = it.next();
                if(!visited.contains(node.getValue()))
                    node.visitDFS(visit, visited);
            }
        }

        private void visitBFS(Consumer<T> visit, HashSet<T> visited) {
            LinkedList<Node<T>> queue = new LinkedList<>();
            queue.add(this);

            while(!queue.isEmpty()) {
                Node<T> node = queue.remove();
                if(!visited.contains(node.getValue())){
                    visit.accept(node.getValue());
                    visited.add(node.getValue());
                    Iterator<Node<T>> it = node.adjacent.iterator();
                    while(it.hasNext()) {
                        queue.add(it.next());
                    }
                }
            }
        }
        @Override
        public boolean equals(Object o) {
            if(this == o)
                return true;
            if(!(o instanceof Node<?>)) return false;
            Node<?> node = (Node<?>) o;
            return this.value.equals(node.value);
        }
    }
    public LinkedList<Node<T>> nodes;


    public static <T> Graph<T> createFromArray(T[] values) {
        int mid = values.length / 2;
        Graph<T> ret = new Graph<>();

        Node<T> root = new Node<>(values[mid]);
        ret.nodes = new LinkedList<>(); 
        ret.nodes.add(root);

        Node<T> current = root;
        for(int i= mid -1; i >=0; i--) {
            Node<T> node = new Node<>(values[i]);
            current.add(node);
            ret.nodes.add(node);
            current = node;
        }
        current = root;
        for(int i = mid + 1; i< values.length; i++) {
            Node<T> node = new Node<>(values[i]);
            current.add(node);
            ret.nodes.add(node);
            current = node;
        }
        return ret;
    }

    public void print(){
        Iterator<Node<T>> it = this.nodes.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void visitDFS(Consumer<T> visit) {
        HashSet<T> visited = new HashSet<>();
        Iterator<Node<T>> it = this.nodes.iterator();
        while(it.hasNext()) {
            Node<T> node = it.next();
            if(!visited.contains(node.getValue()))
                node.visitDFS(visit, visited);
        }
    }
    public void visitBFS(Consumer<T> visit) {
        HashSet<T> visited = new HashSet<>();
        Iterator<Node<T>> it = this.nodes.iterator();
        while(it.hasNext()) {
            Node<T> node = it.next();
            if(!visited.contains(node.getValue()))
                node.visitBFS(visit, visited);
        }
    }

    private Node<T> findNode(T value) {
        Iterator<Node<T>> it = this.nodes.iterator();
        
        while(it.hasNext()) {
            Node<T> node = it.next();
            if(node.getValue().equals(value)) return node;
        }
        return null;
    }

    public boolean existRoute(T n1, T n2) {
        HashSet<T> visited = new HashSet<>();
        Node<T> node1 = findNode(n1);
        LinkedList<Node<T>> queue = new LinkedList<>();
        queue.add(node1);
        visited.add(node1.getValue());
        while(!queue.isEmpty()) {
            Node<T> n = queue.remove();
            if(n.getValue().equals(n2)) return true;
            Iterator<Node<T>> it = n.adjacent.iterator();
            while(it.hasNext()) {
                Node<T> node2 = it.next();
                if(!visited.contains(node2.getValue()))
                    queue.add(node2);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] arrayInt = {1, 2, 3, 7, 4, 5, 6};
        Graph<Integer> g = Graph.createFromArray(arrayInt);
        g.print();
        g.visitDFS(i -> System.out.print(i));
        System.out.println();
        g.visitBFS(i -> System.out.print(i));
        System.out.println();
        System.out.println("Route 7 -> 2 " + g.existRoute(7, 2));
        System.out.println("Route 3 -> 1 " + g.existRoute(3, 1));
        System.out.println("Route 3 -> 6 " + g.existRoute(3, 6));
    }
}