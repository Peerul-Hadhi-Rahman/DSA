import java.util.*;
class Pair{
    int first, second;
    Pair(int first, int second) {
        this.first=first;
        this.second=second;
    }
}
public class Solution {
    static class Graph {
        boolean detectCycle(int V, List<List<Integer>> adj) {
            
            int[] vis=new int[V];
            
            for(int i=0;i<V;i++) {
                if(vis[i]==0) {
                    if(bfs(i, adj, vis)) return true;
                }
            }
            return false;
        }
    };
    private static boolean bfs(int start, List<List<Integer>> adj, int[] vis) {

        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(start, -1));
        vis[start]=1;

        while(!q.isEmpty()) {
            Pair p=q.poll();
            int node=p.first;
            int parent=p.second;

            for(int neighbour:adj.get(node)) {
                if(vis[neighbour]==0) {
                    vis[neighbour]=1;
                    q.offer(new Pair(neighbour, node));
                }
                else if(neighbour!=parent) return true;
            }
        }
        return false;
    }
}
