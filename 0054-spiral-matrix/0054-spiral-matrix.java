class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> ans = new ArrayList<>();
        
        int m = matrix.length;
        int n= matrix[0].length;
        
        int top = 0, left = 0, right = n-1, bottom = m-1;
        int direction = 1;
        
        while(left<=right && top<=bottom)
        {
            if(direction == 1)
            {
                for(int i = left;i<=right;i++)
                {
                    ans.add(matrix[top][i]);
                }
                top++;
                direction = 2;
            }
            
            else if(direction == 2)
            {
                for(int i=top;i<=bottom;i++)
                {
                    ans.add(matrix[i][right]);
                }
                right--;
                direction = 3;
            }
            
            else if(direction == 3)
            {
                for(int i = right; i>=left; i--)
                {
                    ans.add(matrix[bottom][i]);
                    
                }
                bottom--;
                direction = 4;
            }
            
            else if(direction == 4)
            {
                for(int i=bottom; i>=top;i--)
                {
                    ans.add(matrix[i][left]);
                }
                left++;
                direction = 1;
            }
        }
        
        return ans;
        
    }
}

