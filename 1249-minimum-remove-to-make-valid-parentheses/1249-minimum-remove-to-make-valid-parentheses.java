class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            {
                st.push(i);
            }
            else if(ch==')')
            {
                if(st.size()!=0 && s.charAt(st.peek())=='(')
                {
                    st.pop();
                }
                else
                {
                    st.push(i);
                }
            }
            
        }
        
        StringBuilder ans=new StringBuilder();
        
        for(int i=s.length()-1;i>=0;i--)
        {
            if(st.size()!=0 && i==st.peek())
            {
                st.pop();
                continue;
            }
            else
            {
         ans.append(s.charAt(i));
            }
        }
        
        return ans.reverse().toString();
        
    }
}