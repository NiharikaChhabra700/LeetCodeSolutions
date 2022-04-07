class Solution {
    
     public void dfs(int[][] board,int i,int j,int[][] dir)
    {
        board[i][j]=0;
        
        for(int d=0;d<dir.length;d++)
        {
            int x= i + dir[d][0];
            int y= j + dir[d][1];
            
            if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]==1)
            {
                dfs(board,x,y,dir);
            }
        }
    }
    
    
    public int numEnclaves(int[][] board) {
        if(board.length==0 || board[0].length==0)
        {
            return 0;
        }
        
        int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
        int n=board.length;
        int m=board[0].length;
        
        
        for(int i=0;i<board.length;i++)
        {
            if(board[i][0]==1)
            {
                dfs(board,i,0,dir);
            }
            if(board[i][m-1]==1)
            {
                dfs(board,i,m-1,dir);
            }
            
        }
        
        
        
        for(int j=0;j<board[0].length;j++)
        {
            if(board[0][j]==1)
            {
                dfs(board,0,j,dir);
                
            }
            if(board[n-1][j]==1)
            {
                dfs(board,n-1,j,dir);
            }
        }
        
        int count=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]==1)
                {
                    count++;
                }
            }
        }
        
        return count;
        
        
    }
}