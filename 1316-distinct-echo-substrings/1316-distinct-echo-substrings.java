class Solution {
    public int distinctEchoSubstrings(String text) {
        
        HashSet<String> set=new HashSet<>();
        int n=text.length();
        
        
        for(int len=0;len<=n/2;len++)
        {
            int count=0;
            for(int l=0,r=len;r<n;l++,r++)
            {
                if(text.charAt(l)==text.charAt(r))
                {
                    count++;
                }
                else
                {
                    count=0;
                }
                if(count==len)
                {
                    String str=text.substring(l,r);
                    set.add(str);
                    count--;
                }
            }
        }
        
        return set.size();
        
    }
}