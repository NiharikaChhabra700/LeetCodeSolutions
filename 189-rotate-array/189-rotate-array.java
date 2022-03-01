class Solution {
    
    
    public void swap(int[] nums,int i, int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    
    
    public void reverse(int[] nums,int i,int j)
    {
        while(i<=j)
        {
            swap(nums,i++,j--);
        }
    }
    
    
    public void rotate(int[] nums, int k) {
        
        int n=nums.length;
        
        k= (k%n + n) % n;
        
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
}