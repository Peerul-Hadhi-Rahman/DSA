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
        
        int indegree[]=new int[V];
        
        for(int i=0;i<V;i++) {
            for(int nei:adj.get(i)) {
                indegree[nei]++;
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        
        ArrayList<Integer> topo=new ArrayList<>();
        
        while(!q.isEmpty()) {
            int node=q.peek();
            q.remove();
            topo.add(node);
            
            for(int nei:adj.get(node)) {
                indegree[nei]--;
                if(indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }
        return topo;
        
    }
}
