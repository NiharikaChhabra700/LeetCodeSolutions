class Solution {
    
    
    
     public void swap(int[] nums,int i, int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    
    public void sortColors(int[] nums) {
        
        int n=nums.length;
        
        int itr=0;
        int pt1=-1;
        int pt2=n-1;
        
        while(itr<=pt2)
        {
            if(nums[itr]==0)
            {
                swap(nums,++pt1,itr++);
            }
            else if(nums[itr]==2)
            {
                swap(nums,pt2--,itr);
            }
            else
            {
                itr++;
            }
        }
        
        
        
    }
}