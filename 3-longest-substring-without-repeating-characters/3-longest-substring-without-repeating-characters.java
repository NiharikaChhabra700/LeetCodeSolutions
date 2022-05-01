class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int si=0;
        int ei=0;
        
        int len=0;
        
        int[] freq=new int[128];
        int n=s.length();
        int count=0;
        
        while(ei<n)
        {
            if(freq[s.charAt(ei++)]++ >0)
            {
                count++;
            }
            
            while(count>0)
            {
                if(freq[s.charAt(si++)]-- > 1)
                {
                    count--;
                }
            }
            
            len=Math.max(len,ei-si);
            
        }
        
        return len;
    }
}