class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] dp=new boolean[s1.length()+1][s2.length()+1];
        
        if(s1.length()+s2.length()!=s3.length())
        {
            return false;
        }
        
        for(int i=0;i<=s1.length();i++)
        {
            for(int j=0;j<=s2.length();j++ )
            {
                if(i==0 && j==0)
                {
                    dp[i][j]=true;
                }
                
                else if(i==0)
                {
                    dp[i][j]= (s3.charAt(i+j-1)==s2.charAt(j-1)) ? dp[i][j-1] : false; 
                }
                else if(j==0)
                {
                   dp[i][j]= s3.charAt(i+j-1)==s1.charAt(i-1) ? dp[i-1][j] : false; 
                }
                else{
                    
                    if(s1.charAt(i-1)==s3.charAt(i+j-1))
                    {
                        dp[i][j]=dp[i-1][j];
                    }
                    
                    if(!dp[i][j] && s2.charAt(j-1)==s3.charAt(i+j-1))
                    {
                        dp[i][j]=dp[i][j-1];
                    }
                    
                }
            }
        }
        
        return dp[s1.length()][s2.length()];
    }
}