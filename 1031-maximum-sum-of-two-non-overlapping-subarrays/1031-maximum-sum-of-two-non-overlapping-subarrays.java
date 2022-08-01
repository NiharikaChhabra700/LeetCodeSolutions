class Solution {
    public int maxSumTwoNoOverlap(int[] arr, int x, int y) {
        
        int n= arr.length;
        
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        
        int sum = 0;
        int max = 0;
        
        for(int i=0;i<n;i++)
        {
            if(i<x)
            {
                sum += arr[i];
                dp1[i] = sum;
            }
            else
            {
                sum += arr[i] - arr[i-x];
                dp1[i] = Math.max(dp1[i-1],sum);
            }
        }
        
        sum = 0;
        
         for(int i=n - 1;i>=0;i--)
        {
            if(i >= n-y)
            {
                sum += arr[i];
                dp2[i] = sum;
            }
            else
            {
                sum += arr[i] - arr[i+y];
                dp2[i] = Math.max(dp2[i+1],sum);
            }
        }
        
        for(int i = x - 1; i<n-y ; i++)
        {
            max = Math.max(max, dp1[i] + dp2[i+1]);
        }
        
        
        dp1 = new int[n];
        dp2 = new int[n];
        
        
        sum = 0;
        
        for(int i=0;i<n;i++)
        {
            if(i<y)
            {
                sum += arr[i];
                dp1[i] = sum;
            }
            else
            {
                sum += arr[i] - arr[i-y];
                dp1[i] = Math.max(dp1[i-1],sum);
            }
        }
        
        sum =0;
        
         for(int i =n - 1;i>=0;i--)
        {
            if(i >= n-x)
            {
                sum += arr[i];
                dp2[i] = sum;
            }
            else
            {
                sum += arr[i] - arr[i+x];
                dp2[i] = Math.max(dp2[i+1],sum);
            }
        }
        
        for(int i= y - 1; i<n-x ; i++)
        {
            max = Math.max(max, dp1[i] + dp2[i+1]);
        }
        
        
      return max;  
        
        
        
    }
}