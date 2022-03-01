class Solution {
    public String minWindow(String s, String t) {
        
        int ns=s.length();
        int nt=t.length();
        int count=0;
        
        int[] freq=new int[128];
        
        if(ns<nt)
        {
            return "";
        }
        
        for(int i=0;i<nt;i++)
        {
            freq[t.charAt(i)]++;
            count++;
        }
        
        int ei=0,si=0,gsi=0,len=(int)1e9;
        
        while(ei<ns)
        {
            if(freq[s.charAt(ei++)]-->0)
            {
                count--;
            }
            
            while(count==0)
            {
                if(ei-si < len)
                {
                    len=ei-si;
                    gsi=si;
                }
                
                if(freq[s.charAt(si++)]++ == 0)
                {
                    count++;
                }
            }
        }
        
        return len == (int) 1e9 ? "" : s.substring(gsi, gsi + len);
    }
}