class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        
        int si=0,ei=n*m-1;
        
        while(si<=ei)
        {
            int mid=(si+ei)/2;
            
            int r=mid/m;
            int c=mid %m;
            
            if(matrix[r][c]== target)
            {
                return true;
            }
            
            else if(matrix[r][c]<target)
            {
                si=mid+1;
            }
            else
            {
                ei=mid-1;
            }
        }
        
        return false;
    }
}