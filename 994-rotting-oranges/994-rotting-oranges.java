class Solution {
    public int orangesRotting(int[][] grid) {
        
        if(grid.length==0 || grid[0].length==0)
        {
            return -1;
        }
        
        int n=grid.length;
        int m=grid[0].length;
        
        LinkedList<Integer> que=new LinkedList<>();
        int freshoranges=0;
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2) que.addLast(i*m+j);
                else if(grid[i][j]==1) freshoranges++;
                
            }
            
        }
        
        if(freshoranges==0) return 0;
        
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        int time=0;
        
        while(que.size()!=0)
        {
            int size=que.size();
            while(size-->0)
            {
                int idx=que.removeFirst();
                
                int r=idx/m;
                int c=idx%m;
                
                for(int[] d: dir)
                {
                    int x=r+d[0];
                    int y=c+d[1];
                    
                    if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==1)
                    {
                        grid[x][y]=2;
                        que.addLast(x*m+y);
                        freshoranges--;
                        
                        if(freshoranges==0)
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