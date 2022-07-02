class Solution {
    
    
    public void dfs(char[][] grid,int i,int j, int[][] dir)
    {
        grid[i][j]='0';
        
        for(int d=0;d<dir.length;d++)
        {
            int x=i+dir[d][0];
            int y=j+dir[d][1];
            
            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y] == '1')
            {
                dfs(grid,x,y,dir);
            }
        }
    }
    
    
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        if(n==0 && m==0) return 0;
        
        int[][] dir= {{0,-1},{-1,0},{1,0},{0,1}};
        int count = 0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    dfs(grid,i,j,dir);
                }
            }
        }
        
        return count;
        
    }
}