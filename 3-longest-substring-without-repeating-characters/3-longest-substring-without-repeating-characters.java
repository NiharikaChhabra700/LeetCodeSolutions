class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length()<=1) return s.length();
        
        int count=0,len=0,si=0,ei=0;
        int n=s.length();
        
        int[] freq=new int[128];
        
        while(ei<n)
        {
            if(freq[s.charAt(ei++)]++ == 1)
            {
                count++;
            }
            
            while(count>0)
            {
                if(freq[s.charAt(si++)]-- == 2)
                {
                    count--;
                }
        
            }
            
            len=Math.max(ei-si,len);
            
        }
        
        return len;
        
    }
}