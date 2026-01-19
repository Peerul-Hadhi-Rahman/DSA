class Solution {
    int cnt=0;
    int ans=-1;
    public void inorder(TreeNode node, int k) {
        if(node == null) return;
      
        inorder(node.left, k);
        cnt++;

        if(cnt==k) {
            ans=node.val;
            return;
        }
        inorder(node.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }
}
