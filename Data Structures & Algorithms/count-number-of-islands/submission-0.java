class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    cnt++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return cnt;
    }
    public void dfs(int r,int c,char[][] grid,boolean[][] vis){
        int n = grid.length;
        int m = grid[0].length;
        vis[r][c] = true;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        for(int i = 0; i < 4; i++){
            int newr = r + dr[i];
            int newc = c + dc[i];
            if(newr >= 0 && newc >= 0 && newr < n && newc < m){
                if(grid[newr][newc]=='1'&& !vis[newr][newc]){
                    vis[newr][newc] = true;
                    dfs(newr,newc,grid,vis);
                }
            }
        }

    }
}
