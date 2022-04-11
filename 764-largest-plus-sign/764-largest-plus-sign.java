class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        
        int[][] mat=new int[n][n];
        
        for(int[] d: mat)
        {
            Arrays.fill(d,1);
        }
        
        for(int[] mine:mines)
        {
            mat[mine[0]][mine[1]]=0;
        }
        
        int[][] ltr=new int[n][n];
        int[][] tb=new int[n][n];
        
        int[][] rtl=new int[n][n];
        int[][] bt=new int[n][n];
        
        for(int i=0;i<n;i++)
        {
            int runningsum=0;
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0) runningsum=0;
                else
                {
                    runningsum=mat[i][j]+runningsum;
                }
                ltr[i][j]=runningsum;
            }
        }
        
        for(int i=0;i<n;i++)
        {
            int runningsum=0;
            for(int j=n-1;j>=0;j--)
            {
                if(mat[i][j]==0) runningsum=0;
                else
                {
                    runningsum=mat[i][j]+runningsum;
                }
                rtl[i][j]=runningsum;
            }
        }
        
        for(int i=0;i<n;i++)
        {
            int runningsum=0;
            for(int j=0;j<n;j++)
            {
                if(mat[j][i]==0) runningsum=0;
                else
                {
                    runningsum=mat[j][i]+runningsum;
                }
                tb[j][i]=runningsum;
            }
        }
        
        for(int i=0;i<n;i++)
        {
            int runningsum=0;
            for(int j=n-1;j>=0;j--)
            {
                if(mat[j][i]==0) runningsum=0;
                else
                {
                    runningsum=mat[j][i]+runningsum;
                }
                bt[j][i]=runningsum;
            }
        }
        
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int minlen=Math.min(Math.min(tb[i][j],bt[i][j]),Math.min(ltr[i][j],rtl[i][j]));
                ans=Math.max(ans,minlen);
                
            }
        }
        return ans;
    }
}