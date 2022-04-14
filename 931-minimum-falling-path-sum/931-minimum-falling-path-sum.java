class Solution {
    
      public int minFallingPathSum(int[][] nums) {
        int min=Integer.MAX_VALUE;
        int m = nums[0].length;
        int n = nums.length;
        int[][] dp = new int[m][n];
        for(int[] x: dp){
            Arrays.fill(x, -1);
        }
        for(int i=0;i<nums[0].length;i++){
            min= Math.min(min, fun(0,i,nums, dp));
        }
        return min;
    }
    
    int fun(int r, int c,int[][] nums, int[][] dp){
        if(r == nums.length)return 0;
        
        if(r<0 || c<0 || r>=nums[0].length || c>=nums.length){
            return Integer.MAX_VALUE;
        }
        if(dp[r][c] !=-1)return dp[r][c];
        
        int x = fun(r+1, c-1, nums, dp);
        int y = fun(r+1, c, nums, dp);
        int z = fun(r+1, c+1, nums, dp);
        return dp[r][c] = nums[r][c] + Math.min(x, Math.min(y,z));
        
    }
}