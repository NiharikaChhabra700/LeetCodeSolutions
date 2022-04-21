class Solution {
    
    public int targetways(int[] nums,int n,int tar,int sum,int[][] dp)
    {
        if(n==0)
        {
            return dp[n][sum]= (tar==sum) ? 1 : 0;
        }
        
        if(dp[n][sum]!= -1) return dp[n][sum];
        
        int count=0;
        count+= targetways(nums,n-1,tar, sum + nums[n-1],dp);
        count+= targetways(nums,n-1,tar,sum-nums[n-1],dp);
        
        return dp[n][sum]=count;
    }
    
    
    
    
    
    public int findTargetSumWays(int[] nums, int tar) {
        
        int sum=0;
        
        for(int ele:nums)
        {
            sum+=ele;
        }
        
        if(sum<tar || tar < -sum)
        {
            return 0;
        }
        
         int n=nums.length;
        int[][] dp=new int[n+1][2*sum+1];
        for(int[] d : dp) Arrays.fill(d,-1);
       
        
        int ans=targetways(nums,n,tar+sum,sum,dp);
        
        return ans;
    }
}