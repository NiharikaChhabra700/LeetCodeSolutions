class Solution {
    
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public boolean dfs(char[][] board,boolean[][] vis,String word,int i, int j, int idx)
    {
        int n = board.length;
        int m = board[0].length;
        boolean res = false;

        if(idx == word.length())
        {
            return true;
        }
        vis[i][j] = true;
        
        for(int d=0;d<dir.length; d++)
        {
            int x = i + dir[d][0];
            int y = j + dir[d][1];
            
            if(x>=0 && y>=0 && x<n && y<m && board[x][y] == word.charAt(idx) && !vis[x][y])
            {
               res = res || dfs(board,vis,word,x,y,idx+1);
            }
        }
        
        vis[i][j] = false;
        
        return res;
    }
    
    
    
    public boolean exist(char[][] board, String word) {
        
        int n = board.length;
        int m = board[0].length;
        boolean res = false;
        
        boolean[][] vis = new boolean[n][m];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    res = res || dfs(board,vis,word,i,j,1);
                }
            }
        }
        
        return res;
    }
}