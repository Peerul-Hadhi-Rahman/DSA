class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        
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
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<V;i++) {
            if(vis[i] == 0) {
                dfs(i, adj, vis, st);
            }
        }
      
        ArrayList<Integer> ans=new ArrayList<>();
      
        while(!st.isEmpty()) {
            ans.add(st.peek());
            st.pop();
        }
        return ans;     
    }
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> st) {
        vis[node]=1;
        
        for(int nei:adj.get(node)) {
            if(vis[nei] == 0) {
                dfs(nei, adj, vis, st);
            }
        }
        st.push(node);
    }
}
