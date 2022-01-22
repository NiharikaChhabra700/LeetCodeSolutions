class Solution {
    
    public boolean isPossible(int[] nums,int div,int th)
    {
        int res=0;
        for(int i=0;i<nums.length;i++)
        {
            res+=(int)Math.ceil(nums[i]*1.0/div);
            
        }
        
        return res<=th;
    }
    
    
    public int smallestDivisor(int[] nums, int threshold) {
        
        int max=0;
        for(int val:nums)
        {
            max=Math.max(max,val);
        }
        
        int lo=1;
        int hi=max;
        
        int ans=0;
        
        while(lo<=hi)
        {
            int div=lo+(hi-lo)/2;
            
            if(isPossible(nums,div,threshold)==true)
            {
                ans=div;
                hi=div-1;
            }
            else
            {
                lo=div+1;
            }
        }
        
        return ans;
        
    }
}