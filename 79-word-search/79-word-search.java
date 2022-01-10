class Solution {
    
    public boolean dfs(char[][] board,int i,int j,int count,String word,int[][] dir)
    {
        if(count==word.length())
        {
            return true;
        }
        
        boolean res=false;
        
        for(int d=0;d<dir.length;d++)
        {
            int x=i+dir[d][0];
            int y=j+dir[d][1];
            
            if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[i][j]==word.charAt(count))
            {
                char ch=board[i][j];
                
                board[i][j]=' ';
                res=res|| dfs(board,x,y,count+1,word,dir);
                
                board[i][j]=ch;
                
            }
        }
        
        return res;
        
    }
    
    
    public boolean exist(char[][] board, String word) {
      if(board.length==1 && board[0].length==1)
       {
           if(word.length()==1 && board[0][0]==word.charAt(0)) return true;
       }
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==word.charAt(0) && dfs(board,i,j,0,word,dir))
                {
                    return true;
                }
            }
        }
        
        return false;
        
    }
}