class Solution {
    
    public int rec(int i,int j, int[][] dungeon,int[][] dp)
    {
        if(i>=dungeon.length || j>= dungeon[0].length)
        {
           return Integer.MAX_VALUE; 
        }
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        int health=Math.min(rec(i+1,j,dungeon,dp),rec(i,j+1,dungeon,dp));
        
        if(health==Integer.MAX_VALUE)
        {
            health=1;
        }
        
        int res=0;
        if(health-dungeon[i][j]>0)
        {
            res=health-dungeon[i][j];
        }
        else
        {
            res=1;
        }
        
        return dp[i][j]=res;
        
        
        
        
    }
    
    
    
    public int calculateMinimumHP(int[][] dungeon) {
        
        if(dungeon==null || dungeon.length==0 || dungeon[0].length==0)
        {
            return 0;
        }
        
        int n=dungeon.length;
        int m=dungeon[0].length;
        
        
        
        int[][] dp=new int[n][m];
        
        for(int[]d:dp)
        {
            Arrays.fill(d,-1);
        }
        
        return rec(0,0,dungeon,dp);
        
        
        
    }
}