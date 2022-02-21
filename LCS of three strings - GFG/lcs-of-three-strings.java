// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int n1 = Integer.parseInt(input_line[0]);
            int n2 = Integer.parseInt(input_line[1]);
            int n3 = Integer.parseInt(input_line[2]);
            input_line = read.readLine().trim().split("\\s+");
            String A = input_line[0];
            String B = input_line[1];
            String C = input_line[2];
            Solution obj = new Solution();
            System.out.println(obj.LCSof3(A, B, C, n1, n2, n3));
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    public int LCS(String A,String B,String C,int n,int m, int o,int[][][] dp)
    {
        if(n==0 || m==0 || o==0)
        {
            return dp[n][m][o]=0;
        }
        
        if(dp[n][m][o]!=-1) return dp[n][m][o];
        
        if(A.charAt(n-1)==B.charAt(m-1) && B.charAt(m-1)==C.charAt(o-1))
        {
            dp[n][m][o]=1+LCS(A,B,C,n-1,m-1,o-1,dp);
        }
        else
        {
            dp[n][m][o]=Math.max(Math.max(LCS(A,B,C,n-1,m,o,dp),LCS(A,B,C,n,m-1,o,dp)),LCS(A,B,C,n,m,o-1,dp));
        }
        
        return dp[n][m][o];
    }
    
    
    
    int LCSof3(String A, String B, String C, int n, int m, int o) 
    { 
          int [][][] dp=new int[n+1][m+1][o+1];
          for(int[][] d: dp)
          {
              for(int [] p: d)
              {
                  Arrays.fill(p,-1);
              }
          }
          
          return LCS(A,B,C,n,m,o,dp);
    }
} 