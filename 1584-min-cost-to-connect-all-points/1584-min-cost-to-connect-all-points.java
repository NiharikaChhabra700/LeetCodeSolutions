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
    
    
    public int minCostConnectPoints(int[][] points) {
        
        ArrayList<int[]> graph = new ArrayList<>();
        
        for(int i=0;i<points.length; i++)
        {
            for(int j=i+1;j<points.length;j++)
            {
               int w = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
               graph.add(new int[]{i,j,w});   
            }
        }
        
        Collections.sort(graph, (a,b) ->{
            return a[2] - b[2];
        });
        
        int n = points.length;
        
        par = new int[n];
        
        for(int i=0;i<n;i++)
        {
            par[i] = i;
        }
        int cost = 0;
        
        for(int[] e : graph)
        {
            int u = e[0],v = e[1], w=e[2];
            int p1 = findPar(u);
            int p2 = findPar(v);
            
            if(p1!=p2)
            {
                par[p2] =p1;
                cost+= w;
            }
        }
        
        return cost;
        
    }
}