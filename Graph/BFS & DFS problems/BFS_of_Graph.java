class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        
     int V = adj.size();
     ArrayList<Integer> result = new ArrayList<>();
     
     Queue<Integer> q = new LinkedList<>();
     boolean[] vis = new boolean[V];
     
     q.offer(0);
     vis[0] = true;
     
     while(!q.isEmpty()) {
         int node = q.poll();
         result.add(node);
         
         for(int neighbor : adj.get(node)) {
             if(vis[neighbor] == false) {
                 vis[neighbor] = true;
                 q.offer(neighbor);
             }
         }
     }
     return result;
    }
}
