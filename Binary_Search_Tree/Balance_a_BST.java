class Solution {
     ArrayList<Integer> inorder=new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorderTraversal(root);
        return bst(0, inorder.size()-1);
    }
    private void inorderTraversal(TreeNode node) {
        if(node == null) return;
        inorderTraversal(node.left);
        inorder.add(node.val);
        inorderTraversal(node.right);
    }
    private TreeNode bst(int left, int right) {
        if(left>right) return null;

        int mid=left+(right-left)/2;

        TreeNode root=new TreeNode(inorder.get(mid));
        root.left=bst(left, mid-1);
        root.right=bst(mid+1, right);
        return root;
    }
}
