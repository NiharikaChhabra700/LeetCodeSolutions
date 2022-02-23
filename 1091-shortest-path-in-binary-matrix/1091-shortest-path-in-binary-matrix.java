class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length==0 || grid[0].length==0)
        {
            return -1;
        }
        
        int n=grid.length;
        int m=grid[0].length;
        
        if(grid[0][0]== 1 || grid[n-1][m-1]==1)
        {
            return -1;
        }
        
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,1},{-1,-1},{1,-1}};
        
        LinkedList<Integer> que=new LinkedList<>();
        
        que.addLast(0);
        int shortestpath=1;
        
        while(que.size()!=0)
        {
            int size=que.size();
            
            while(size-->0)
            {
                int idx=que.removeFirst();
                
                int r=idx/m;
                int c=idx%m;
                
                if(r==n-1 && c==m-1)
                {
                    return shortestpath;
                }
                
                for(int[] d: dir)
                {
                    int x= r+d[0];
                    int y=c+ d[1];
                    
                    if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==0)
                    {
                        grid[x][y]=1;
                        que.addLast(x*m+y);
                    }
        
                }
            }
            
            shortestpath++;
        }
        
        return -1;
        
    }
}