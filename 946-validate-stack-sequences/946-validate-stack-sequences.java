class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        Stack<Integer> st=new Stack<>();
        
        int n=pushed.length;
        int i=0;
        
        for(int ele:pushed)
        {
            st.push(ele);
            while(st.size()!=0 && st.peek()==popped[i])
            {
                st.pop();
                i++;
            }
            
        }
        
        return st.size()==0;
    }
}