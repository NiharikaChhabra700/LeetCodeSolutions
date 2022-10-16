class Solution {
    
    public void dfs(char[][] grid,int i ,int j, int[][] dir)
    {
        grid[i][j] = '0';
        
        for(int d=0;d<dir.length ;d++)
        {
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            
            if(r>=0 && c>=0 && r < grid.length && c<grid[0].length && grid[r][c] == '1')
            {
                dfs(grid,r,c, dir);
            }
            
        }
    }
    
    
    
    
    
    public int numIslands(char[][] grid) {
        
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        
        if(grid.length == 0 || grid[0].length == 0)
        {
            return 0;
        }
        
        int count = 0;
        
        for(int i = 0;i<grid.length;i++)
        {
            for(int j = 0; j<grid[0].length ; j++ )
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    dfs(grid,i,j,dir);
                }
            }
        }
        
        
        return count;
        
    }
}