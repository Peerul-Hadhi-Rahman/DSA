class Solution {
    private void dfs(int row, int col, char[][] board, boolean[][] vis, int[] delr, int[] delc){
        vis[row][col]=true;
        int m=board.length;
        int n=board[0].length;

        for(int i=0;i<4;i++) {
            int nr=row+delr[i];
            int nc=col+delc[i];

            if(nr>=0 && nc>=0 && nr<m && nc<n && 
            !vis[nr][nc] && board[nr][nc] == 'O'){
                dfs(nr, nc, board, vis, delr, delc);
            } 
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;

        int[] delr={-1, 0, 1, 0};
        int[] delc={0, 1, 0, -1};

        boolean[][] vis=new boolean[m][n];

         
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O' && !vis[0][j])
                dfs(0, j, board, vis, delr, delc);

            if (board[m - 1][j] == 'O' && !vis[m - 1][j])
                dfs(m - 1, j, board, vis, delr, delc);
        }

       
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && !vis[i][0])
                dfs(i, 0, board, vis, delr, delc);

            if (board[i][n - 1] == 'O' && !vis[i][n - 1])
                dfs(i, n - 1, board, vis, delr, delc);
        }

       for(int i=0;i<m;i++) {
        for(int j=0;j<n;j++) {
            if(!vis[i][j] && board[i][j]=='O' ) {
                board[i][j]='X';
            }
        }
       }
    }
}
