class Solution {
    
    public int maxSum(int... arr)
    {
        int max = -(int)1e9;
        for(int i : arr)
        {
            max = Math.max(i,max);
        }
        
        return max;
    }
    
    public int maxProduct(int[] nums1, int[] nums2, int n , int m , int[][] dp)
    {
        if(n== 0 || m==0)
        {
            return dp[n][m] = -(int)1e9;
        }
        
        if(dp[n][m]!= -(int)1e8) return dp[n][m];
        
        int acceptBothNumbers = maxProduct(nums1, nums2, n-1, m-1, dp) + nums1[n-1]*nums2[m-1];
        int a = maxProduct(nums1, nums2, n-1, m, dp) ;
        int b = maxProduct(nums1, nums2, n, m-1, dp) ;
        
        return dp[n][m]= maxSum(acceptBothNumbers,a,b,nums1[n-1]*nums2[m-1]);
    }
    
    
    public int maxDotProduct(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int m = nums2.length;
        
        int[][] dp = new int[n+1][m+1];
        
        for(int[]d : dp)
        {
            Arrays.fill(d, -(int)1e8);
        }
        
        return maxProduct(nums1,nums2,n,m,dp);
        
        
    }
}