class Solution {
    public int findLUSlength(String[] strs) {
        
        int maxlen=-1;
        
        for(int i=0;i<strs.length;i++)
        {
            int currlen=strs[i].length();
            boolean flag=false;
            
            for(int j=0;j<strs.length;j++)
            {
                if(i!=j)
                {
                    if(iscommonsubseq(strs[i],strs[j]))
                    {
                        flag=true;
                        break;
                    }
                }
            }
            
            if(!flag)
            {
                maxlen=Math.max(maxlen,currlen);
            }
        }
        
        return maxlen;
    }
    
    public boolean iscommonsubseq(String a,String b)
    {
        if(a.equals(b)) return true;
        
        int i=0,j=0;
        
        while(i<a.length() && j<b.length())
        {
            if(a.charAt(i)==b.charAt(j++))
            {
                i++;
            }
        }
        
        return i==a.length();
    }
}