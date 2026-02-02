class Solution {

public int countComponents(int V, ArrayList<ArrayList<Integer>> adj) {
  boolean[] visited = new boolean[V];
  int components = 0;
  for(int i=0;i<V;i++) {
    if(!visited[i]) {
      components++;
      dfs(i, adj, visited);
    }
  }
  return components;
}
  
private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
  visited[node] = true;
  
  for(int neighbor : adj.get(node)) {
    if(!visited[neighbor]) {
      dfs(neighbor, adj, visited);
    }
  }
}
}
