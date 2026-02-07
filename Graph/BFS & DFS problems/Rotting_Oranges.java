class Solution {
    public int orangesRotting(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;

        Queue<int[]> q=new LinkedList<>();
        int fresh=0;

        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
            int[][] dir={{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int mins=0;

            while(!q.isEmpty() && fresh>0) {
                int size=q.size();
                mins++;

                for(int i=0;i<size;i++){
                    int[] cur=q.poll();

                    for(int[] d:dir){
                        int r=cur[0] + d[0];
                        int c=cur[1] + d[1];

                        if(r>=0 && c>=0 && r<rows && c<cols && grid[r][c] == 1) {
                            grid[r][c]=2;
                            fresh--;
                            q.offer(new int[]{r, c});
                    }
                }
            }
        }
        return fresh == 0? mins : -1;
    }
}
