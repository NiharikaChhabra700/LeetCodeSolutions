class Solution {
    public int findNumberOfLIS(int[] arr) {
        
        int maxlength=0;
        int maxcount=0;
        
        int n= arr.length;
        
        int[] dp=new int[n];
        int[] count=new int[n];
        
        for(int i=0;i<n;i++)
        {
            dp[i]=1;
            count[i]=1;
            
            for(int j=i-1;j>=0;j--)
            {
                if(arr[j]<arr[i])
                {
                    if(dp[j]+1 > dp[i])
                    {
                        dp[i] = dp[j]+1;
                        count[i] = count[j];
                    }
                    else if(dp[j]+1 == dp[i])
                    {
                        count[i]+=count[j];
                    }
                }
            }
            
            if(dp[i]>maxlength)
            {
                maxlength=dp[i];
                maxcount=count[i];
            }
            else if(dp[i]==maxlength)
            {
                maxcount+=count[i];
            }
        }
        
        
        return maxcount;
        
    }
}