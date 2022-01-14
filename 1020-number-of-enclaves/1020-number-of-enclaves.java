class Solution {

    public void dfs(int[][] grid,int i ,int j,int[][] dir)
    {
        grid[i][j]=0;
        
        for(int d=0;d<dir.length;d++)
        {
            int x=i+dir[d][0];
            int y=j+dir[d][1];
            
            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1)
            {
                dfs(grid,x,y,dir);
            }
        }
    }
    
    
    
    public int numEnclaves(int[][] grid) {
        if(grid.length==0 || grid[0].length==0 )
        {
            return 0;
        }
        
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1)
                {
                    if(grid[i][j]==1)
                    {
                        dfs(grid,i,j,dir);
                    }
                }
            }
        }
        
        
        int count=0;
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    count++;
                }
            }
        }
        
        return count;
        
    }
}