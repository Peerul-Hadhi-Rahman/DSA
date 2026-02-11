class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];

        for(int i=0;i<n;i++) {
            if(color[i]==0) {
                if(!dfs(i, 1, graph, color)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int node, int c, int[][] graph, int[] color) {
        color[node]=c;

        for(int neighbor:graph[node]) {
            if(color[neighbor]==0) {
                if(!dfs(neighbor, -c, graph, color)){
                    return false;
                }
            }
            else if(color[neighbor]==c) {
                return false;
            }
        }
        return true;
    }
}
