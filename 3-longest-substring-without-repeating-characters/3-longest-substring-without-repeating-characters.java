class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ei=0;
        int si=0;
        
        int n=s.length();
        int[] freq=new int[128];
        
        int count=0,len=0;
        
        while(ei<n)
        {
            if(freq[s.charAt(ei++)]++ > 0)
                count++;
            
            if(count>0)
            {
                if(freq[s.charAt(si++)]-- >1)
                {
                    count--;
                }
            }
            
            
            len=Math.max(len,ei-si);
        }
        
        return len;
    }
}