class Solution {
    public int maxDistance(int[][] grid) {
        
        LinkedList<Integer> que=new LinkedList<>();
        
        int n=grid.length;
        int m=grid[0].length;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    que.addLast(i*m+j);
                }
            }
        }
        
        if(que.size()==0 || que.size()==n*m)
        {
            return -1;
        }
        int level=-1;
        int[][] dir={{0,1},{0,-1},{-1,0},{1,0}};
        
        while(que.size()!=0)
        {
            int size=que.size();
            while(size-->0)
            {
                int idx=que.removeFirst();
                
                int r=idx/m;
                int c=idx%m;
                
                for(int d=0;d<dir.length;d++)
                {
                    int x=r+dir[d][0];
                    int y=c+dir[d][1];
                    
                    if(x>=0 && y>=0 && x<n && y<m && grid[x][y]!=1)
                    {
                        que.addLast(x*m+y);
                        grid[x][y]=1;
                    }
                }
            }
            
            level++;
        }
        
        return level;
    }
}