class Solution {
    
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};

    public void dfs(int[][] grid,int row,int col,int givencell)
    {
        grid[row][col]= -givencell;
        int count=0;
        
        for(int d=0;d<dir.length;d++)
        {
            int x=row+dir[d][0];
            int y=col+dir[d][1];
            
            if(x<0 || y<0 || x>= grid.length || y>=grid[0].length || Math.abs(grid[x][y])!= givencell)
            {
                continue;
            }
            
            count++;
            
            if(grid[x][y]==givencell)
            {
                dfs(grid,x,y,givencell);
            }
        }
        
        if(count==4)
        {
            grid[row][col]=givencell;
        }
    }
    
    
    
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        dfs(grid,row,col,grid[row][col]);
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]<0)
                {
                    grid[i][j]=color;
                }
            }
        }
        
        return grid;
    }
}