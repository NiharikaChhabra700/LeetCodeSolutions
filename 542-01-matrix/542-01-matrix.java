class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        LinkedList<Integer> que=new LinkedList<>();
        
        int n=mat.length;
        int m=mat[0].length;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==0)
                {
                    que.addLast(i*m+j);
                }
                else 
                {
                    mat[i][j]=-1;
                }
            }
        }
        
        int[][] dir={{0,1},{0,-1},{-1,0},{1,0}};
        
        while(que.size()!=0)
        {
            int idx=que.removeFirst();
            
            int r=idx/m;
            int c=idx%m;
            
            for(int d=0;d<dir.length;d++)
            {
                int x=r+dir[d][0];
                int y=c+dir[d][1];
                
                if(x>=0 && y>=0 && x<n && y<m && mat[x][y]<0)
                {
                    que.addLast(x*m+y);
                    mat[x][y]=mat[r][c]+1;
                }
            }
        }
        
        
        return mat;
        
    }
}