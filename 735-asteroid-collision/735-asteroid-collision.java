class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        LinkedList<Integer> st=new LinkedList<>();
        
        int n=asteroids.length;
        
        for(int ele:asteroids)
        {
            if(ele>0)
            {
                st.push(ele);
                continue;
            }
            
            while(st.size()!=0 && st.getFirst()>0 && st.getFirst()<-ele) st.removeFirst();
            
            if(st.size()==0 || st.getFirst()<0) st.push(ele);
            
            else if(st.size()!=0 && st.getFirst()==-ele) st.removeFirst();
            
            else{
                
            }
            
        }
        
        int[] ans=new int[st.size()];
        
        int idx=st.size()-1;
        
        while(st.size()!=0)
        {
            ans[idx--]=st.removeFirst();
        }
        
        return ans;
    }
}