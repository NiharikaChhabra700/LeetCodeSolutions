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
            System.out.println(ob.countNumberswith4(N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int countNumberswith4(int n) {
        // code here
        int count=0;
        
        boolean[] dp=new boolean[n+1];
        
        for(int i=2;i<=n;i++)
        {
            if(dp[i])
            {
                count++;
                continue;
                
            }
            if(contains(i))
            {
                dp[i]=true;
                count++;
            }
        }
        
        return count;
    }
    
    static boolean contains(int i)
    {
        while(i>0)
        {
            if(i%10 == 4) return true;
            i=i/10;
        }
        
        return false;
    }
};