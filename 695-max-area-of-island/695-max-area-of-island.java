class Solution {
    
    public int FindArea(int[][] grid, int i, int j, int[][] dir)
    {
        grid[i][j] = 0;
        int area=1;
        
        for(int d=0;d<dir.length;d++)
        {
            int r = i+ dir[d][0];
            int c = j+ dir[d][1];
            
            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c] ==1)
            {
                area+= FindArea(grid,r,c,dir);
            }
        }
        
        return area;
    }
    
    
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int n= grid.length;
        int m= grid[0].length;
        
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        
        int maxArea = 0;
        
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 1)
                {
                    maxArea =Math.max(maxArea ,FindArea(grid, i, j, dir));
                }
            }
        }
        
        return maxArea;
        
    }
}