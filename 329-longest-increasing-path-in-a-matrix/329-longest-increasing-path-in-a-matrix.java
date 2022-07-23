class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[][] indegree = new int[n][m];
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        
        for(int i=0; i<n ; i++)
        {
            for(int j=0; j<m ; j++)
            {
                for(int d=0;d<dir.length;d++)
                {
                    int r = i + dir[d][0];
                    int c = j + dir[d][1];
                    
                    if(r>=0 && c>=0 && r<n && c<m && matrix[r][c] > matrix[i][j])
                    {
                        indegree[r][c]++;
                    }
                }
            }
        }
        
        LinkedList<Integer> que=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(indegree[i][j]==0) que.addLast(i*m+j);
            }
        }
        
        int level = 0;
        
        while(que.size()!=0 )
        {
            int size = que.size();
            while(size-- > 0)
            {
                int idx = que.removeFirst();
                int r = idx/m;
                int c = idx%m;
                
                for(int d = 0 ;d< dir.length; d++)
                {
                    int i = r + dir[d][0];
                    int j = c + dir[d][1];
                    
                    if(i>=0 && j>=0 && i<n && j<m && matrix[i][j] > matrix[r][c] && --indegree[i][j] == 0)
                    {
                        que.addLast(i*m+j);
                    }
                }
            }
            level ++;
        }
        
        
        return level;
    }
}