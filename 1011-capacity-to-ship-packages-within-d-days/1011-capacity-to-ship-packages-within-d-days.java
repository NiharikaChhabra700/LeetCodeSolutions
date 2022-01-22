class Solution {
    
    public boolean ispossible(int[] weights,int mid,int days)
    {
        int d=1;
        int sum=0;
        for(int i=0;i<weights.length;i++)
        {
            sum+=weights[i];
            if(sum>mid)
            {
                d++;
                sum=weights[i];
            }
        }
        
        return d<=days;
    }
    
    
    
    
    public int shipWithinDays(int[] weights, int days) {
        
        int max=0;
        int sum=0;
        
        for(int val:weights)
        {
            max=Math.max(val,max);
            sum+=val;
        }
        
        if(days == weights.length) return max;
        
        int hi=sum;
        int lo=max;
        int ans=0;
        
        while(lo<=hi)
        {
            int mid=lo+(hi-lo)/2;
            
            if(ispossible(weights,mid,days))
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