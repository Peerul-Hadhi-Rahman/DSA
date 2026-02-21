class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++) {
            int u=prerequisites[i][1];
            int v=prerequisites[i][0];
            adj.get(u).add(v);
        }

        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++) {
            for(int nei:adj.get(i)) {
                indegree[nei]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] ans=new int[numCourses];
        int idx=0;
        while(!q.isEmpty()) {
            int node=q.peek();
            q.remove(node);
            ans[idx++]=node;

            for(int nei:adj.get(node)) {
                indegree[nei]--;
                if(indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }
       if(idx==numCourses) return ans;
       else return new int[0];

    }
}
