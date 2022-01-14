class Solution {
    
     public class Pair
    {
        int x;
        int y;
        Pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    
    
    public int maxDistance(int[][] grid) {
        LinkedList<Pair> que=new LinkedList<>();
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    que.addLast(new Pair(i,j));
                }
            }
        }
        
        if(que.size()==0 || que.size() == grid.length*grid[0].length)
        {
            return -1;
            
        }
         int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        
        int level=-1;
        
        while(que.size()!=0)
        {
            level++;
            int size=que.size();
            
            while(size-->0)
            {
                Pair rem=que.removeFirst();
                
                for(int d=0;d<dir.length;d++)
                {
                    int x=rem.x+dir[d][0];
                    int y=rem.y+dir[d][1];
                    
                    if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]==1)
                    {
                        continue;
                    }
                    
                    grid[x][y]=1;
                    que.addLast(new Pair(x,y));
                }
            }
        }
        
        
        return level;
    }
}