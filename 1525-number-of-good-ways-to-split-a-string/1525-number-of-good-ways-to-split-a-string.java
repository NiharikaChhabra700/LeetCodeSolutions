class Solution {
    public int numSplits(String s) {
        
        int n = s.length();
        int[] prefix=new int[n];
        int[] suffix=new int[n];
        
        int goodways=0;
        
        Set<Character> preset=new HashSet<>();
        Set<Character> suffset=new HashSet<>();
        
        for(int i=0;i<s.length();i++)
        {
            preset.add(s.charAt(i));
            suffset.add(s.charAt(n-i-1));
            
            prefix[i]=preset.size();
            suffix[n-i-1]=suffset.size();
        
        }
        
        for(int i=1;i<n;i++)
        {
            if(prefix[i-1]==suffix[i])
            {
                goodways++;
            }
        }
        
        
        return goodways;
        
    }
}