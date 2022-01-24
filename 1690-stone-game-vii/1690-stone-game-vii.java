class Solution {
    
    int[] pre;
    
    public int rec(int[] stones,int i,int j,int[][] dp)
    {
        if(i>=j) return 0;
        
        if(i+1==j) return Math.max(stones[i],stones[j]);
        
        if(dp[i][j]!=0) return dp[i][j];
        
        int scoreI=pre[j]-pre[i]-rec(stones,i+1,j,dp);
        int scoreJ=pre[j-1]- ( i == 0 ? 0 : pre[i-1])-rec(stones,i,j-1,dp);
        
        return dp[i][j]= Math.max(scoreI,scoreJ);
    }
    
    
    public int stoneGameVII(int[] stones) {
        
        int n=stones.length;
        int[][] dp=new int[n][n];
        pre=new int[n];
        
        pre[0]=stones[0];
        for(int i=1;i<n;i++)
        {
            pre[i]=pre[i-1]+stones[i];
        }
        
        return rec(stones,0,n-1,dp);
        
        
    }
}