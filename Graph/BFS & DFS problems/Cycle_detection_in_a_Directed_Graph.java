class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++) {
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
        }
        
        int[] vis=new int[V];
        int[] pathVis=new int[V];
        
        for(int i=0;i<V;i++) {
            if(vis[i] == 0) {
                if(dfs(i, adj, vis, pathVis)) {
                return true;
                }
            }
        }
        return false;
    }
        private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis) {
            vis[node]=1;
            pathVis[node]=1;
            
            for(int neighbour:adj.get(node)) {
                if(vis[neighbour]==0) {
                    if(dfs(neighbour, adj, vis, pathVis)) {
                        return true;
                    }
                }
                else if(pathVis[neighbour]==1) {
                    return true;
                }
            }
            pathVis[node]=0;
            return false;
        }
    }
