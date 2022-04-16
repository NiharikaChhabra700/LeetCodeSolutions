class Solution {
    
    public int coinchange(int[] coins,int amount,int[] dp)
    {
        if(amount==0)
        {
            return dp[amount]=0;
        }
        
        if(dp[amount]!=(int)1e9)
        {
            return dp[amount];
        }
        
        int mincoins=(int)1e8;
        
        for(int ele:coins)
        {
            if(amount-ele>=0)
            {
                mincoins=Math.min(mincoins,coinchange(coins,amount-ele,dp)+1);
            }
        }
        
        return dp[amount]=mincoins;
    }
    
    
    
    
    public int coinChange(int[] coins, int amount) {
        
        int[] dp=new int[amount+1];
        Arrays.fill(dp,(int)1e9);
        
        int ans=coinchange(coins,amount,dp);
        
        return ans!=(int)1e8 ? ans : -1;
        
    }
}