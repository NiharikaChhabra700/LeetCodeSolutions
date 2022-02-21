class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> set=new HashSet<>();
        
        for(String str: wordDict)
        {
            set.add(str);
        }
        
        int[] dp=new int[s.length()];
        
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<=i;j++)
            {
                String substr=s.substring(j,i+1);
                if(set.contains(substr))
                {
                    if(j>0)
                    {
                        dp[i]+=dp[j-1]; 
                    }
                    else
                    {
                        dp[i]=1;   //agar pehla hi substring valid hua toh j-1 toh invalid index dedega toh just add one in that case
                    }
                }
            }
        }
        
        
        return dp[s.length()-1]>0;
        
    }
}