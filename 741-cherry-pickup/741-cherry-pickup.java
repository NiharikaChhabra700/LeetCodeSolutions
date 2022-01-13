class Solution {
    
    
    public int cp(int r1,int c1,int r2,int[][] grid,int[][][] dp)
    {
        int c2=r1+c1-r2;
        
        if(r1>=grid.length || r2>=grid.length || c1>=grid[0].length || c2>=grid[0].length ||  grid[r1][c1] == -1 || grid[r2][c2] ==-1)
        {
            return Integer.MIN_VALUE;
        }
        
         if(dp[r1][c1][r2]!= 0)
        {
            return dp[r1][c1][r2];
        }
        
        if(r1==grid.length-1 && c1== grid[0].length-1)
        {
            return grid[r1][c1];
        }
        
       
         
        int cherries=0;
        if(r1==r2 && c1==c2)
        {
            cherries+=grid[r1][c1];
        }
        else
        {
            cherries+=grid[r1][c1]+grid[r2][c2];
        }
        
        int f1=cp(r1+1,c1,r2+1,grid,dp);
        int f2=cp(r1,c1+1,r2+1,grid,dp);
        int f3=cp(r1+1,c1,r2,grid,dp);
        int f4=cp(r1,c1+1,r2,grid,dp);
        
        cherries+=Math.max(Math.max(f1,f2),Math.max(f3,f4));
        dp[r1][c1][r2]=cherries;

        
        return cherries;
        
    }
    
    public int cherryPickup(int[][] grid) {
        
        int n=grid.length;
        
        int[][][] dp=new int[n][n][n];
        
        int ans=cp(0,0,0,grid,dp);
        
        return Math.max(0,cp(0,0,0,grid,dp));
        
    }
}