class Solution {
    
    public boolean bipartite(List<Integer>[] graph,int src,int[] vis)
    {
        LinkedList<Integer> que=new LinkedList<>();
        que.addLast(src);
        
        int color=0;
        
        while(que.size()!=0)
        {
            int size=que.size();
            while(size-->0)
            {
                int rvtx=que.removeFirst();
                
                if(vis[rvtx]!=-1)
                {
                    if(vis[rvtx]!=color)
                    {
                        return false;
                    }
                    continue;
                }
                
                vis[rvtx]=color;
                
                for(int v : graph[rvtx])
                {
                    if(vis[v]==-1)
                    {
                        que.addLast(v);
                    }
                }
            }
            
            color=(color+1)%2;
        }
        
        return true;
    }
    
    
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        List<Integer>[] graph =new ArrayList[n+1];
        
        for(int i=0;i<=n;i++)
        {
            graph[i]= new ArrayList<>();
        }
        
        for(int[] v : dislikes)
        {
            graph[v[0]].add(v[1]);
            graph[v[1]].add(v[0]);
        }
        
        int[] vis=new int[n+1];
        Arrays.fill(vis,-1);
        
        boolean res= true;
        
        for(int i=1;i<=n;i++)
        {
            if(vis[i] == -1)
            {
            res = res && bipartite(graph,i,vis);
            }
        }
        
        return res;
        
    }
}