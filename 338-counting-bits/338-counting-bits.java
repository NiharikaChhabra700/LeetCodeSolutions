class Solution {
    
    public int rec(int n,int[] dp)
    {
        if(n==0)
        {
            return 0;
        }
        
        if(n==1)
        {
            return 1;
        }
        
        if(dp[n]!=0) return dp[n];
        
        if(n%2==0) 
        {
            return dp[n]=rec(n/2,dp);
        }
        else
        {
            return dp[n]=1+rec((n/2),dp);
        }
        
        
    }
    
    
    public int[] countBits(int n) {
        
        int[] dp=new int[n+1];
        
        for(int i=0;i<=n;i++)
        {
            dp[i]=rec(i,dp);
        }
        return dp;
        
    }
}