class Solution {
    int[] par;
    public int findPar(int u)
    {
        return par[u] == u ? u : findPar(par[u]);
    }
    public int[] findRedundantConnection(int[][] edges) {
        
        int n =edges.length;
        par=new int[n+1];
        
        for(int i=0;i<n;i++)
        {
            par[i]=i;
        }
        
        for(int[] e : edges)
        {
            int p1= findPar(e[0]);
            int p2= findPar(e[1]);
            
            if(p1!=p2)
            {
                par[p1]=p2;
            }
            else
            {
                return e;
            }
        }
        
                return new int[0];
        
        
        
    }
}