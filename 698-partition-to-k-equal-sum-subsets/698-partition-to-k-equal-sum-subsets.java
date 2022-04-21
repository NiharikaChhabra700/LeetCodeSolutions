class Solution {
    
    public boolean canpartition(int[] arr,int k,int idx,int sumsf,int tar,boolean[] vis)
    {
        if(k==0)
        {
            return true;
        }
        
        if(sumsf> tar) return false;
        
        if(sumsf==tar)
        {
            return canpartition(arr,k-1,0,0,tar,vis);
        }
        
        
        boolean res=false;
        for(int i=idx;i<arr.length;i++)
        {
            if(vis[i]) continue;
            
            vis[i]=true;
            res=res || canpartition(arr,k,i+1,sumsf+arr[i],tar,vis);
            vis[i]=false;
        }
        
        return res;
    }
    
    
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int sum=0;
        int maxele=0;
        
        for(int ele:nums)
        {
            sum+=ele;
            maxele=Math.max(maxele,ele);
        }
        
        if(sum%k != 0 || maxele >sum/k) return false;
        
        int n=nums.length;
        
        boolean[] vis=new boolean[n];
        return canpartition(nums,k,0,0,sum/k,vis);
        
        
    }
}