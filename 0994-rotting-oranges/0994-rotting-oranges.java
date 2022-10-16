class Solution {
    public int orangesRotting(int[][] grid) {
        
    int freshOranges = 0;
    int rottenOranges = 0;
        
    int n=grid.length;
    int m = grid[0].length;
        
    LinkedList<Integer> que= new LinkedList<>();
    int[][] dir= {{1,0},{-1,0},{0,1},{0,-1}};
        
        
    for(int i=0;i<grid.length;i++)
    {
        for(int j=0;j<grid[0].length;j++)
        {
            if(grid[i][j] == 2)
            {
                que.addLast(i*m+j);
            }
            
            else if(grid[i][j] == 1)
            {
                freshOranges++;
            }

        }
    }
        
        if(freshOranges == 0)
        {
            return 0;
        }
        
        int time = 0;
        
        while(que.size() !=0)
        {
            int size = que.size();
            
            while(size-->0)
            {
                int idx = que.removeFirst();
                int  r = idx/m;
                int c = idx%m;
                
                for(int d=0;d<dir.length;d++)
                {
                    int i = r + dir[d][0];
                    int j = c + dir[d][1];
                    
                    if(i>=0 && j>=0 && i<n && j<m && grid[i][j] ==1)
                    {
                        grid[i][j] =2;
                        freshOranges --;
                        que.addLast(i*m+j);
                    }
                    if(freshOranges == 0)
                    {
                        return time+1;
                    }
                }
            }
            time++;
        }
        
        return -1;
        
    }
}