class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first=first;
        this.second=second;
    }
}
class Solution {
    private void bfs(int r, int c, int[][] vis, char[][] grid) {
        vis[r][c]=1;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(r, c));

        int n=grid.length;
        int m=grid[0].length;

        int[] dRow={-1, 0, 1, 0};
        int[] dCol={0, 1, 0, -1};

        while(!q.isEmpty()) {
            Pair p=q.poll();
            int row=p.first;
            int col=p.second;

            for(int i=0;i<4;i++) {
                int newRow=row+dRow[i];
                int newCol=col+dCol[i];

                 if(newRow>=0 && newRow<n && 
                       newCol>=0 && newCol<m &&
                       grid[newRow][newCol] == '1' && 
                       vis[newRow][newCol] == 0) {

                            vis[newRow][newCol]=1;
                            q.add(new Pair(newRow, newCol));
                        }
            } 
                }
            }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis= new int[n][m];
        int cnt=0;

        for(int row=0;row<n;row++) {
            for(int col=0;col<m;col++) {
                if(vis[row][col]==0 && grid[row][col]=='1'){
                    cnt++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return cnt;
    }
}
