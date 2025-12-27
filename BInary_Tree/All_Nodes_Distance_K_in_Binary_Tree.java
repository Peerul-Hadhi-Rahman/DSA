class Solution {
    Map<TreeNode, TreeNode> parent=new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildParent(root, null);
        
        Queue<TreeNode> q=new LinkedList<>();
        Set<TreeNode> visited=new HashSet<>();
        
        q.offer(target);
        visited.add(target);

        int dist=0;

        while (!q.isEmpty()) {
            int size=q.size();
            if (dist==k) break;

            for (int i=0;i<size;i++) {
                TreeNode curr=q.poll();

                if (curr.left!=null && !visited.contains(curr.left)) {
                    q.offer(curr.left);
                    visited.add(curr.left);
                }
                if (curr.right!=null && !visited.contains(curr.right)) {
                    q.offer(curr.right);
                    visited.add(curr.right);
                }
                if (parent.get(curr)!=null && !visited.contains(parent.get(curr))) {
                    q.offer(parent.get(curr));
                    visited.add(parent.get(curr));
                }
            }
            dist++;
        }

        List<Integer> result=new ArrayList<>();
        while(!q.isEmpty()) {
            result.add(q.poll().val);
        }
        return result;
    }

    public void buildParent(TreeNode node, TreeNode par) {
        if (node==null) return;
        parent.put(node, par);
        buildParent(node.left, node);
        buildParent(node.right, node);
    }
}
