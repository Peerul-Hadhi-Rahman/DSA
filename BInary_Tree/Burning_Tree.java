class Solution {
    Map<Node, Node> parent=new HashMap<>();
    public int minTime(Node root, int target) {
        parent.clear();
        Node targetN=targetNode(root, null, target);
        
        Queue<Node> q=new LinkedList<>();
        Set<Node> visited=new HashSet<>();
        
        q.offer(targetN);
        visited.add(targetN);
        
        int time=0;
        
        while (!q.isEmpty()) {
            int size=q.size();
            boolean burned=false;
            
            for (int i=0;i<size;i++) {
                Node curr=q.poll();
                
                if (curr.left!=null && !visited.contains(curr.left)) {
                    q.offer(curr.left);
                    visited.add(curr.left);
                    burned=true;
                }
                if (curr.right!=null && !visited.contains(curr.right)) {
                    q.offer(curr.right);
                    visited.add(curr.right);
                    burned=true;
                }
                if (parent.get(curr)!=null && !visited.contains(parent.get(curr))) {
                    q.offer(parent.get(curr));
                    visited.add(parent.get(curr));
                    burned=true;
                }
            }
            if (burned) time++;
        }
        return time;
    }
    
    public Node targetNode(Node node, Node par, int target) {
        if (node==null) return null;
        parent.put(node, par);
        
        if(node.data==target) return node;
        
        Node left=targetNode(node.left, node, target);
        if (left!=null) return left;
        
        return targetNode(node.right, node, target);
    }
}
