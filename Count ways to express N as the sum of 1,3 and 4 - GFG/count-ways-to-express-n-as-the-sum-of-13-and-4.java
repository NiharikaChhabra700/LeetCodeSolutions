// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countWays(N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long countWays(int n) {
        
        long[] dp=new long[n+1];
        
        if(n==1) return (long)1;
        if(n==2) return (long)1;
        if(n==3) return (long)2;
        if(n==4) return (long)3;
        
        dp[0]=1;
        dp[1]=1;
        dp[2]=1;
        dp[3]=2;
        
        long mod=(long)1e9+7;
        
        for(int i=4;i<=n;i++)
        {
            dp[i]=((dp[i-1]%mod)+(dp[i-3]%mod)+(dp[i-4]%mod));
        }
        
        return dp[n]%mod;
        
        

    }
};