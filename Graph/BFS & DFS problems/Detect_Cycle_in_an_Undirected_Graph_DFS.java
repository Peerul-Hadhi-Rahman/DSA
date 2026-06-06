public class Solution {
    static class Graph {
        boolean detectCycle(int V, List<List<Integer>> adj) {
            
            int[] vis=new int[V];
            
            for(int i=0;i<V;i++) {
                if(vis[i]==0) {
                    if(dfs(i, -1, adj, vis)) return true;
                }
            }
            return false;
        }
    };
    private static boolean dfs(int node, int parent, List<List<Integer>> adj, int[] vis) {
        vis[node]=1;
        for(int x:adj.get(node)) {
            if(vis[x]==0) {
                if(dfs(x, node, adj, vis)) return true;
            }
            else if(x!=parent) return true;
        }
        return false;
    }
}
