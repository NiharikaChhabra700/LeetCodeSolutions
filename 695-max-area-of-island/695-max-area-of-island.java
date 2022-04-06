class Solution {
    
    public int dfs(int i,int j,int n,int m,int[][] grid,int[][] dir)
    {
        
        int area=1;
        grid[i][j]=0;
        
        for(int d=0;d<dir.length;d++)
        {
            int r=i+dir[d][0];
            int c=j+dir[d][1];
            
            if(r>=0 && c>=0 && r<n && c<m && grid[r][c]==1)
            {
                
                area+=dfs(r,c,n,m,grid,dir);
            }
        }
        
        
        return area;
    }
    
    
    
    
    public int maxAreaOfIsland(int[][] grid) {
        
        if(grid.length==0 || grid[0].length==0)
        {
            return 0;
        }
        
        int n=grid.length;
        int m=grid[0].length;
        
        int area=0;
           int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]== 1)
                {
                    area=Math.max(area, dfs(i,j,n,m,grid,dir));
                }
            }
        }
        
        return area;
        
        
    }
}