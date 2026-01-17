class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else {
            if (root.left == null) 
            return root.right;

            if (root.right == null) 
            return root.left;

            TreeNode successor = getMin(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }
    private TreeNode getMin(TreeNode node) {
        while (node.left != null) 
        node = node.left;
        return node;
    }
}
