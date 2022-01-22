class Solution {
    
    public boolean ispossible(int[] nums,int mid,int m)
    {
        int d=1;
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(sum>mid)
            {
                d++;
                sum=nums[i];
            }
        }
        
        return d<=m;
    }
    
    
    public int splitArray(int[] nums, int m) {
        
        int max=0;
        int sum=0;
        
        for(int val:nums)
        {
            max=Math.max(val,max);
            sum+=val;
        }
        
        if(m == nums.length) return max;
        
        int hi=sum;
        int lo=max;
        int ans=0;
        
        while(lo<=hi)
        {
            int mid=lo+(hi-lo)/2;
            
            if(ispossible(nums,mid,m))
            {
                ans=mid;
                hi=mid-1;
            }
            else
            {
                lo=mid+1;
            }
        }
        
        
        return ans;
        
    }
}