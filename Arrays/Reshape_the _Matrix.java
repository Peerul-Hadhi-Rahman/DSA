class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m=mat.length;
        int n=mat[0].length;
        
        if(r*c!=m*n) return mat;
        
        int[][] result=new int[r][c];
        int idx=0;

       for(int i=0;i<m;i++) {
        for(int j=0;j<n;j++) {
            result[idx/c][idx%c]=mat[i][j];
            idx++;
        }
       }
     return result;  
    }
}
