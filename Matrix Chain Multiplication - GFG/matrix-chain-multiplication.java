// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int n , int arr[])
    {
        int[][] dp=new int[n][n];
        
        for(int gap=2;gap<n;gap++)
        {
            for(int si=0,ei=gap;ei<n;si++,ei++)
            {
                if(si+1==ei)
                {
                    dp[si][ei]=0;
                    continue;
                }
                
                int ans=(int)1e9;
                for(int cut=si+1;cut<ei;cut++)
                {
                    int lans=dp[si][cut];
                    int rans=dp[cut][ei];
                    
                    ans=Math.min(ans,lans+ (arr[si] * arr[cut] * arr[ei]) + rans);
                    
                    
                }
               dp[si][ei]=ans; 
                
                
            }
        }
        
        return dp[0][n-1];
    }
}