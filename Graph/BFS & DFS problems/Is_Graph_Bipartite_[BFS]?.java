class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];

        for(int i=0;i<n;i++) {
            if(color[i]==0) {
                if(!bfs(i, graph, color)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean bfs(int start, int[][] graph, int[] color) {
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        color[start]=1;

        while(!q.isEmpty()) {
            int node=q.poll();

            for(int neighbor : graph[node]) {
                if(color[neighbor]==0) {
                    color[neighbor]=-color[node];
                    q.offer(neighbor);
                }
                else if(color[neighbor]==color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}
