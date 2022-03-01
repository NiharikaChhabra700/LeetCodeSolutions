class Solution {
    public int maxArea(int[] height) {
        
        int n=height.length;
        
        int i=0;
        int j=n-1;
        
        int maxArea=0;
        
        
        while(i<=j)
        {
            int min=Math.min(height[i],height[j]);
            maxArea=Math.max(maxArea,min* (j-i));
            
            if(height[i]<height[j])
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        
        return maxArea;
        
    }
}