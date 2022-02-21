class Solution {
    
    public int minimum(int n,int[] cost,int[] dp)
    {
        if(n<=1)
        {
            return dp[n]=cost[n];
        }
        
        if(dp[n]!=-1) return dp[n];
        
        int mincost=Math.min(minimum(n-1,cost,dp),minimum(n-2,cost,dp));
        
        return dp[n] = mincost + ((n==cost.length) ? 0 : cost[n]);
         
        
    }
    
    
    
    public int minCostClimbingStairs(int[] cost) {
        
        int n=cost.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        
        minimum(n,cost,dp);
        
        return dp[n];
        
    }
}