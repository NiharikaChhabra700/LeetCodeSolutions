class Solution {
    public int orangesRotting(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        
        LinkedList<Integer> que=new LinkedList<>();
        
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        
        int freshOranges=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    que.addLast(i*m+j);
                }
                else if(grid[i][j]==1)
                {
                    freshOranges++;
                }
            }
        }
        
        if(freshOranges == 0) return 0;
        int time=0;
        
        while(que.size()!=0)
        {
            int size= que.size();
            while(size-- > 0)
            {
                int idx = que.removeFirst();
                
                int r = idx/m;
                int c = idx%m;
                
                for(int d=0;d<dir.length;d++)
                {
                    int x = r + dir[d][0];
                    int y = c + dir[d][1];
                    
                    if(x>=0 && y>=0 && x<n && y<m && grid[x][y] ==1 )
                    {
                        grid[x][y] =2;
                        que.addLast(x*m+y);
                        freshOranges--;
                        
                        if(freshOranges == 0)
                        {
                            return time+1;
                        }
                    }
                }
            }
            time++;
        }
        
        return -1;
    
        
    }
}