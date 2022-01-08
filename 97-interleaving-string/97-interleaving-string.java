class Solution {
    
    public Boolean solve(String s1, String s2, String s3,int i,int j,Boolean dp[][])
    {
     
     if(i==s1.length()&&j==s2.length())
         return true;//perfectly matched if got till here
        
     if(dp[i][j]!=null)
         return dp[i][j];
        
     if(i<s1.length()&&s1.charAt(i)==s3.charAt(i+j))
     {
         dp[i][j]=solve(s1,s2,s3,i+1,j,dp);
         if(dp[i][j]==true)//directly return mat krna ,next ko bhi check 
             return dp[i][j];
     }
        
     if(j<s2.length()&&s2.charAt(j)==s3.charAt(i+j))
     {
         dp[i][j]=solve(s1,s2,s3,i,j+1,dp);
         if(dp[i][j]==true)
             return dp[i][j];
     }
     
     dp[i][j]=false;
     return dp[i][j];
    }
    
    
    public boolean sol(String s1,String s2,String s3,int i, int j,Boolean[][] dp)
    {
        if(i==s1.length() && j==s2.length())
        {
            return dp[i][j]=true;
        }
        
        if(dp[i][j] !=null) return dp[i][j];
        
        if(i<s1.length() && s1.charAt(i)==s3.charAt(i+j))
        {
            Boolean f1=sol(s1,s2,s3,i+1,j,dp);
            dp[i][j]=f1;
            
            if(f1==true)
            {
                return true;
            }
        }
        
        if(j<s2.length() && s2.charAt(j)==s3.charAt(i+j))
        {
            Boolean f2=sol(s1,s2,s3,i,j+1,dp);
            dp[i][j]=f2;
            if(f2)
            {
                return true;
            }
        }
        
        dp[i][j]=false;
        return false;
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
         return false;
        
        return sol(s1,s2,s3,0,0,new Boolean[s1.length()+1][s2.length()+1]);
        
    }
}