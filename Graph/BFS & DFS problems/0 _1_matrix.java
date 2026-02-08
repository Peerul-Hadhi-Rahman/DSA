class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;

        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
                else {
                    mat[i][j] = -1;
                }
            }
        }
        int[] dr={-1, 0, 1, 0};
        int[] dc={0, 1, 0, -1};

        while(!q.isEmpty()) {
            int[] cell=q.poll();
            int r=cell[0];
            int c=cell[1];

            for(int d=0;d<4;d++) {
                int nr=r+dr[d];
                int nc=c+dc[d];

                if(nr>=0 && nc>=0 && nr<m && nc<n && mat[nr][nc] == -1) {
                    mat[nr][nc] = mat[r][c]+1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return mat;
     }
}
