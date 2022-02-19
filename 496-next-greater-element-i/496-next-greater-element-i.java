class Solution {
    
    public int[] ngor(int[] arr)
    {
        int[] ans=new int[arr.length];
        Arrays.fill(ans,-1);
        
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<arr.length;i++ )
        {
            while(st.size()!=0 && arr[st.peek()]<arr[i])
            {
                ans[st.pop()]=i;
            }
            
            st.push(i);
        }
        
        return ans;
    }
    
    
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int[] ng=ngor(nums2);
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums2.length;i++)
        {
            map.put(nums2[i], ng[i]!= -1 ? nums2[ng[i]] : -1);
        }
        
        int[] ans=new int[nums1.length];
        
        for(int i=0;i<nums1.length;i++)
        {
            ans[i]=map.get(nums1[i]);
            
        }
        
        
        return ans;
    }
}