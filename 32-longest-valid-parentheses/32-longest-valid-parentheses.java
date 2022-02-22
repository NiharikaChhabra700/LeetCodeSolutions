class Solution {
    public int longestValidParentheses(String s) {
        int left=0;
        int right=0;
        int max=0;
        
        for(int i=0;i<s.length();i++) //for prefix
        {
            char ch=s.charAt(i);
            
            if(ch == '(')
            {
                left++;
            }
            else
            {
                right++;
            }
            
            if(left==right)
            {
                max=Math.max(max,left+right);
            }
            if(right>left) 
            {
                left=0;
                right=0;
            }
        }
        left=right=0;
        
        for(int i=s.length()-1;i>=0;i--) //for suffix
        {
            char ch=s.charAt(i);
            
            if(ch == '(')
            {
                left++;
            }
            else
            {
                right++;
            }
            
            if(left==right)
            {
                max=Math.max(max,left+right);
            }
            
            if(left>right)
            {
                left=0;
                right=0;
            }
            
        }
        
        return max;
        
    }
}