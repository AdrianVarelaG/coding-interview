package tree;

import java.util.*;

public class ListDepth {
    
    private static interface Number<T> {
        boolean isNewLine();
        T getValue();

        public static <T> Number<T> value(T value){
            return new NumberI<>(value);
        }
        public static <T> Number<T> newLine(){
            return new NewLine<>();
        }

        public class NumberI<T> implements Number<T> {
            private T value;
            private NumberI(T number) {
                this.value = number;
            }
            @Override
            public boolean isNewLine(){
                return false;
            }
            @Override
            public T getValue() {
                return this.value;
            }
        }
        public class NewLine<T> implements Number<T> {
            private NewLine(){

            }
            @Override
            public boolean isNewLine(){
                return true;
            }
            @Override
            public T getValue() {
                return null;
            }
        }
    }
    
    
    public static void main(String[] args) {
        Integer[] arrInteger = { 1,2,3,4,5,6,7, 8, 9, 10, 11, 12, 13 , 14, 15};
        TreeNode tree = TreeNode.fromArray(arrInteger);
        System.out.print(tree.toString());
        List<List<Integer>> lists = listOfDepths(tree);

        for(List<Integer> l : lists) {
            System.out.println(l);
        }

    }

    public static List<List<Integer>> listOfDepths(TreeNode root) {
        LinkedList<Number<TreeNode>> queue = new LinkedList<>();
        queue.add(Number.value(root));
        queue.add(Number.newLine());
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            Number<TreeNode> e = queue.remove();
            if(e.isNewLine()){
                if ( list.isEmpty() )
                    break;
                ret.add(list);
                list = new ArrayList<>();
                queue.add(Number.newLine());
            }else {
                TreeNode node = e.getValue();
                list.add(node.getData());
                if(node.left != null)
                    queue.add(Number.value(node.left));
                if(node.right != null)
                    queue.add(Number.value(node.right));
            }
        }
        return ret;
    }
}