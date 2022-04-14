class Solution {
    
    
    
    public boolean willtravel(int cday,int[] days)
    {
        for(int i=0;i<days.length;i++)
        {
            if(cday==days[i])
            {
                return true;
            }
        }
        
        return false;
    }
    
    public int rec(int cday,int[] days,int[] costs,int[] dp)
    {
        if(cday>days[days.length-1])
        {
            return dp[cday]=0;
        }
        
        if(dp[cday]!=-1)
        {
            return dp[cday];
        }
        
        int ans=(int)1e8;
        if(willtravel(cday,days))
        {
            ans=rec(cday+1,days,costs,dp)+costs[0];
            ans=Math.min(ans,rec(cday+7,days,costs,dp)+costs[1]);
            ans=Math.min(ans,rec(cday+30,days,costs,dp)+costs[2]);
        }
        else
        {
            return dp[cday]=rec(cday+1,days,costs,dp);
        }
        
        return dp[cday]=ans;
    }
    
    
    
    public int mincostTickets(int[] days, int[] costs) {
        
        int[] dp=new int[400];
        Arrays.fill(dp,-1);
        
        return rec(days[0],days,costs,dp);
        
    }
}