class Solution {
    
    public void dfs(int i,int j,int n,int m,char[][] grid,int[][] dir)
    {
            for(int d=0;d<dir.length;d++)
        {
            int r=i+dir[d][0];
            int c=j+dir[d][1];
            
            if(r>=0 && c>=0 && r<n && c<m && grid[r][c] == '1' )
            {
                grid[r][c] = '0';
                dfs(r,c,n,m,grid,dir);
            }
        }
    }
    
    
    
    public int numIslands(char[][] grid) {
        
        if(grid.length==0 || grid[0].length==0)
        {
            return 0;
        }
        
        int n=grid.length;
        int m=grid[0].length;
        
        int count=0;
        
         int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
        
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    dfs(i,j,n,m,grid,dir);
                }
            }
        }
        
        return count;
        
    }
}