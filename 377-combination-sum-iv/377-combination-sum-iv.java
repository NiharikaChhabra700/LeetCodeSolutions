class Solution {
    public int combinationSum4(int[] nums, int Tar) {
        
        int[] dp=new int[Tar+1];
        
        dp[0]=1;
        
        for(int tar=0;tar<=Tar;tar++)
        {
            for(int ele:nums)
            {
                if(tar-ele>=0)
                {
                    dp[tar]+=dp[tar-ele];
                }
            }
        }
        
        return dp[Tar];
        
        
        
    }
}