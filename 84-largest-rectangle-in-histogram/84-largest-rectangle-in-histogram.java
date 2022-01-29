class Solution {
    public void NSOR(int[] arr,int[] ans)
{
    int n=arr.length;
    Arrays.fill(ans,n);

    Stack<Integer> st=new Stack<>();

    for(int i=0;i<n;i++)
    {
        while(st.size()!=0 && arr[st.peek()]>arr[i])
        {
            ans[st.pop()]=i;

        }
        st.push(i);
    }
}

public void NSOL(int[] arr,int[] ans)
{
    int n=arr.length;
    Arrays.fill(ans,-1);

    Stack<Integer> st=new Stack<>();

    for(int i=n-1;i>=0;i--)
    {
        while(st.size()!=0 && arr[st.peek()]>arr[i])
        {
            ans[st.pop()]=i;

        }
        st.push(i);
    }
}
    
    public int largestRectangleArea(int[] heights) {
        
    int n=heights.length;
    int[] nsol=new int[n];
    int[] nsor=new int[n];
    NSOL(heights,nsol);
    NSOR(heights,nsor);
    int maxArea=0;
    for(int i=0;i<n;i++)
    {
        int h=heights[i];
        int w=nsor[i]-nsol[i]-1;
        
        maxArea=Math.max(maxArea,h*w);
        
        
    }
        return maxArea;
        
    }
}