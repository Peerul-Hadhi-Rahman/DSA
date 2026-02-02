class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
      
        int V = adj.size();
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] vis = new boolean[V];
        
        dfsOfGraph(0, adj, vis, result);
        return result;
    }
     public void  dfsOfGraph(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> result) {
         
         vis[node] = true;
         result.add(node);
         
         for(int neighbor : adj.get(node)) {
             if(!vis[neighbor]) {
                 dfsOfGraph(neighbor, adj, vis, result);
             }
         }
     }
}
