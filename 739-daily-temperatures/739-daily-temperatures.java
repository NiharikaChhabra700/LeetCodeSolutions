class Solution {
    
    
    public int[] ngor(int[] arr)
    {
        int n=arr.length;
        int[] ans=new int[n];
        Arrays.fill(ans,0);
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<n;i++)
        {
            while(st.size()!=0 && arr[st.peek()]<arr[i])
            {
                ans[st.pop()]=i;
            }
            st.push(i);
        }
        
        return ans;
    }
    
    
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] ans=ngor(temperatures);
        int[] sol=new int[ans.length];
        
        for(int i=0;i<ans.length;i++)
        {
            if(ans[i]!=0)
            {
            sol[i]= ans[i] - i;
            }
            else
            {
                sol[i]=0;
            }
            
            
        }
        
        return sol;
        
        
    }
}