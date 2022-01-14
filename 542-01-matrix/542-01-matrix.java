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
    
    
    public int[][] updateMatrix(int[][] mat) {
        LinkedList<Pair> que=new LinkedList<>();
        
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==0)
                {
                    que.addLast(new Pair(i,j));
                }
                else
                {
                    mat[i][j]=-1;
                }
            }
        }
        
         int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        
        
        while(que.size()!=0)
        {
            Pair rem=que.removeFirst();
            
            for(int d=0;d<dir.length;d++)
            {
                int x=rem.x+dir[d][0];
                int y=rem.y+dir[d][1];
                
                if(x>=0 && y>=0 && x<mat.length && y<mat[0].length && mat[x][y]<0)
                {
                    que.addLast(new Pair(x,y));
                    mat[x][y]=mat[rem.x][rem.y]+1;
                }
            }
        }
        
        return mat;
        
    }
}