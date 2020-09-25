package tree;

public class TreeNode {
    private Integer data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Integer data) {
        this.data = data;
    }

    public void add(Integer data) {
        if(this.data < data ){
            if(left != null)
                this.left.add(data);
            else
                this.left = new TreeNode(data);
        }else {
            if(right != null)
                this.right.add(data);
            else    
                this.right = new TreeNode(data);
        }
    }

    

}