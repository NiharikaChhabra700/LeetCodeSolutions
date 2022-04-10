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
    
    public void dfs(int i,int j,int[][] grid,LinkedList<Pair> que,boolean[][] vis,int[][] dir)
    {
        vis[i][j]=true;
        que.addLast(new Pair(i,j));
        for(int d=0;d<dir.length;d++)
        {
            int x=i+dir[d][0];
            int y=j+dir[d][1];
            
            if(x<0 || y<0 || x>= grid.length || y>=grid[0].length || vis[x][y]==true || grid[x][y]==0 )
            {
                continue;
            }
            
            dfs(x,y,grid,que,vis,dir);
        }
    }
    
    
    public int shortestBridge(int[][] grid) {
        LinkedList<Pair> que=new LinkedList<>();
        boolean flag=false;
        
        int n=grid.length;
        int m=grid[0].length;
        
        boolean[][] visited=new boolean[n][m];
         int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        
        
        for(int i=0;i<grid.length && !flag;i++)
        {
            for(int j=0;j<grid[0].length && !flag ;j++)
            {
                if(grid[i][j]==1)
                {
                    dfs(i,j,grid,que,visited,dir);
                    flag=true;  
                }
            }
        }
        
        int level=0;
        while(que.size()!=0)
        {
            int size=que.size();
            
            while(size-->0)
            {
                Pair rem=que.removeFirst();
                
                for(int d=0;d<dir.length;d++)
                {
                    int i=rem.x + dir[d][0];
                    int j=rem.y + dir[d][1];
                    
                    if(i<0 || j<0 || i>=grid.length || j>=grid[0].length ||  visited[i][j]==true)
                    {
                        continue;
                    }
                    
                    if(grid[i][j]==1)
                    {
                        return level;
                    }
                    
                    que.addLast(new Pair(i,j));
                    visited[i][j]=true;
                    
                }
            }
            level++;
        }
        
        
        return level;
        
    }
}