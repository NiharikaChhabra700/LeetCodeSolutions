class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n=matrix.length;
        int m=matrix[0].length;
        
        int si=n-1;
        int ei=0;
        
        while(si>=0 && ei<m)
        {
            if(matrix[si][ei]==target)
            {
                return true;
            }
            else if(matrix[si][ei]<target)
            {
                ei++;
            }
            else
            {
                si--;
            }
        }
        
        return false;
    }
}