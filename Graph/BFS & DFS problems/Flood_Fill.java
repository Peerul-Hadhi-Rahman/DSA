class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor=image[sr][sc];
        if(initialColor==color) return image;
        dfs(sr, sc, image, color, initialColor);
        return image;
    }
    public void dfs(int row, int col, int[][] image, int color, int initialColor) {
        int n=image.length;
        int m=image[0].length;

        if(row<0 || col<0 || row>=n || col>=m || image[row][col] != initialColor){
            return;
        }
        image[row][col]=color;

        dfs(row-1, col, image, color, initialColor);
        dfs(row+1, col, image, color, initialColor);
        dfs(row, col-1, image, color, initialColor);
        dfs(row, col+1, image, color, initialColor);
    }
}
