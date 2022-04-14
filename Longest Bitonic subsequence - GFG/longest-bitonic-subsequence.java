// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] LIS_LR(int[] arr)
    {
        int n=arr.length;
        
        int[] dp=new int[n];
        
        Arrays.fill(dp,1);
        
        for(int i=0;i<n;i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                if(arr[i]>arr[j])
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        
        return dp;
    }
    
    public int[] LIS_RL(int[] arr)
    {
        int n=arr.length;
        
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        
        for(int i=n-1;i>=0;i--)
        {
            for(int j=i+1;j<n;j++)
            {
                if(arr[i]>arr[j])
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        
        return dp;
    }
    
    
    public int LongestBitonicSequence(int[] nums)
    {
        int[] LIS=LIS_LR(nums);
        int[] LDS=LIS_RL(nums);
        
        int max=0;
        
        for(int i=0;i<nums.length;i++)
        {
            max=Math.max(max,LIS[i]+LDS[i]-1);
        }
        
        return max;
    }
}