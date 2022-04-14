class Solution {
    public int findLongestChain(int[][] pairs) {
        
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int n=pairs.length;
        int[] dp=new int[pairs.length];
        
        for(int i=0;i<dp.length;i++)
        {
            dp[i]=1;
        }
        int max=0;
        
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(pairs[i][0]>pairs[j][1] )
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                
                }
            }
        }
        
        for(int x: dp)if(x>max) max=x;
        
       return max;
        
    }
}