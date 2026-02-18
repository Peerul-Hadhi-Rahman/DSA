class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;

        int[] vis=new int[V];
        int[] pathVis=new int[V];
        int[] check=new int[V];

        for(int i=0;i<V;i++) {
            if(vis[i] == 0) {
                dfs(i, graph, vis, pathVis, check);
            }
        }

        List<Integer> safeNodes=new ArrayList<>();
        for(int i=0;i<V;i++) {
            if(check[i] == 1) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
    
    private boolean dfs(int node, int[][] graph, int[] vis, int[] pathVis, int[] check) {
        vis[node]=1;
        pathVis[node]=1;

        for(int nei:graph[node]) {
            if(vis[nei] == 0) {
                if(dfs(nei, graph, vis, pathVis, check) == true) {
                    return true;
                }
            }
            else if(pathVis[nei] == 1) {
                 return true;
            }
        }
        check[node]=1;
        pathVis[node]=0;
        return false;
    }
}
