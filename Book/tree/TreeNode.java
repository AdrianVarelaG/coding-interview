package tree;

public class TreeNode {
    private Integer data;
    private TreeNode left;
    private TreeNode right;

    private static String SPACE = "     ";

    public TreeNode(Integer data) {
        this.data = data;
    }

    public void add(Integer data) {
        if(this.data < data ){
            if(right != null)
                this.right.add(data);
            else    
                this.right = new TreeNode(data);
        }else {
            if(left != null)
                this.left.add(data);
            else
                this.left = new TreeNode(data);
            
        }
    }

    private void printTree(StringBuilder sb, int level) {
        if(this.right != null) {
            this.right.printTree(sb, level+1);
        }
        for(int i =0; i < level ; i++)
            sb.append(TreeNode.SPACE);
        sb.append(data).append(System.lineSeparator());
        if(this.left != null) {
            this.left.printTree(sb, level+1);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        printTree(sb, 0);
        return sb.toString();
    }

    public static TreeNode fromArray(Integer[] arr) {
        return TreeNode.fromArray(arr, 0, arr.length-1);
    }

    private static TreeNode fromArray(Integer[] arr, Integer start, Integer end) {
        Integer mid = start + ((end - start)/2);
        if(start == end)
            return new TreeNode(arr[start]);
        else if(start > end)
            return null;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = TreeNode.fromArray(arr, start, mid-1);
        node.right = TreeNode.fromArray(arr, mid+1, end);
        return node;
    }
    

    public static void main(String[] args) {
        Integer[] arrInteger = { 1,2,3,4,5,6,7, 8, 9, 10, 11, 12, 13 , 14, 15};
        TreeNode tree = TreeNode.fromArray(arrInteger);
        System.out.print(tree.toString());
    }
}