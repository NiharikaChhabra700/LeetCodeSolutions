class Solution {
    
 
    
    public int[][] updateMatrix(int[][] mat) {
       LinkedList<Integer> que=new LinkedList<>();
       int n=mat.length;
       int m=mat[0].length;
        
        boolean[][] vis=new boolean[n][m];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==0)
                {
                    que.addLast(i*m+j);
                    vis[i][j]=true;
                }
            }
        }
        
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        
        
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
                    int y=c+ d[1];
                    
                    if(x>=0 && y>=0 && x<n && y<m && !vis[x][y])
                    {
                        mat[x][y]=mat[r][c]+1;
                        vis[x][y]=true;
                        que.addLast(x*m+y);
                    }
                }
            }
        }
        
        return mat;
        
    }
}