package tree;

public class TreeNode {
    private Integer data;
    public TreeNode left;
    public TreeNode right;

    private static String SPACE = "     ";

    public TreeNode(Integer data) {
        this.data = data;
    }

    public Integer getData(){
        return this.data;
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

    public boolean checkBalancer(){
        Integer height = TreeNode.checkBalancer(this);
        if(Integer.MIN_VALUE == height) return false;
        return true;
    }

    private static Integer checkBalancer(TreeNode root){
        if(root == null) return 0;
        
        Integer left = TreeNode.checkBalancer(root.left);
        if(left == Integer.MIN_VALUE) return left;

        Integer right = TreeNode.checkBalancer(root.right); 
        if(right == Integer.MIN_VALUE) return right;

        Integer diff = left - right;

        if(Math.abs(diff) > 1) return Integer.MIN_VALUE;
        return Math.max(left, right) + 1;

    }

    public boolean validBST(){
        Integer left = this.left != null ? this.left.data : Integer.MIN_VALUE;
        Integer right = this.right != null ? this.right.data : Integer.MAX_VALUE;

        boolean result = (left <= this.data) && (this.data < right);
        if(result) {
            boolean bleft = this.left != null ? this.left.validBST() : true;
            boolean bright = this.right != null ? this.right.validBST() : true;
            result = bleft && bright;
        }
        return result;
    }

    public static TreeNode fromArray(Integer[] arr) {
        return TreeNode.fromArray(arr, 0, arr.length-1);
    }

    public static TreeNode fromArrayUn(Integer[] arr) {
        Integer mid = arr.length / 2;
        TreeNode root = new TreeNode(arr[mid]);
        TreeNode current = root;

        for(int i = mid +-1; i >=0 ; i--) {
            TreeNode node = new TreeNode(arr[i]);
            current.left = node;
            current = node;
        }
        current = root;
        for(int i = mid +1; i < arr.length; i++) {
            TreeNode node = new TreeNode(arr[i]);
            current.right = node;
            current = node;
        }

        return root;
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
        Integer[] arrInteger2 = { 10, 25 ,20,30,35};
        TreeNode tree = TreeNode.fromArray(arrInteger);
        TreeNode treeUn = TreeNode.fromArrayUn(arrInteger);
        TreeNode tree2 = TreeNode.fromArray(arrInteger2);
        System.out.print(tree.toString());
        System.out.print(treeUn.toString());
        System.out.println();
        System.out.println("tree isbalance: " + tree.checkBalancer());
        System.out.println("treeUn isbalance: " + treeUn.checkBalancer());
        System.out.println(tree2.toString());

        System.out.println("Tree is a BST: " + tree.validBST());
        System.out.println("Tree2 is a BST: " + tree2.validBST());

    }
}