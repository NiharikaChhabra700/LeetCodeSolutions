class Solution {
    
    public int help(int n,int[] dp)
    {
        if(n==1) return dp[n]=0;
        
        if(dp[n]!=-1) return dp[n];
        
        else
        {
            for(int i=1;i<n;i++)
            {
                if(n%i==0)
                {
                    if(help(n-i,dp)==0) return dp[n]=1;
                }
            }
            
            return dp[n]= 0;
        }
    }
    
    
    public boolean divisorGame(int n) {
        int[] dp=new int[1001];
        Arrays.fill(dp,-1);
        
        help(n,dp);
        return dp[n]==1;
        
        
        
    }
}