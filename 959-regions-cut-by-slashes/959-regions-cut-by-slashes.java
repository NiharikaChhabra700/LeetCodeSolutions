class Solution {
    int[] par;
    
    public int findPar(int u)
    {
        if(par[u] == u)
        {
            return u;
        }
        else
        {
            return par[u] = findPar(par[u]);
        }
    }
    
    
    public int regionsBySlashes(String[] grid) {
        
        int n=grid.length;
        int N = n+1;
        par = new int[N*N];
        
        for(int i=0;i<N*N;i++)
        {
            if(i/N == 0 || i %N == 0 || i/N == N-1 || i%N == N-1)
            {
                par[i] = 0;
            }
            else
            {
                par[i] = i;
            }
            
        }
        
        int region=1;
        
        for(int r=0 ; r < n ; r++)
        {
            String str = grid[r]; 
            for(int c=0;c<str.length();c++)
            {
                
                if(str.charAt(c) == '/')
                {
                    int p1 = findPar(r*N + c+1);
                    int p2 = findPar((r+1)*N + c);
                    
                    if(p1!=p2)
                    {
                        par[p1] = Math.min(p1,p2);
                        par[p2] = Math.min(p1,p2);
                    }
                    else
                    {
                        region++;
                    }
                }
                
                else if(str.charAt(c) == '\\')
                {
                    int p1 = findPar(r*N + c);
                    int p2 = findPar((r+1)*N + c+1);
                    
                    if(p1!=p2)
                    {
                        par[p1] = Math.min(p1,p2);
                        par[p2] = Math.min(p1,p2);
                    }
                    else
                    {
                        region++;
                    }
                }
            
                
            }
            
        }
        
        return region;
        
        
    }
}