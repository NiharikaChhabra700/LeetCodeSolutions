class Solution {
    
    public class pair{
        
        int src;
        int par;
        int w;
        int wsf;
        
        pair(int src, int par, int w, int wsf)
        {
            this.src = src;
            this.par = par;
            this.w = w;
            this.wsf = wsf;
        }
    }
    
    
    public int networkDelayTime(int[][] times, int n, int k) {
        
        
        ArrayList<int[]>[] graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++)
        {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] time : times)
        {
            graph[time[0]].add(new int[]{time[1],time[2]});  
        }
        
        PriorityQueue<pair> pq =new PriorityQueue<>((a,b) ->{
            return a.wsf - b.wsf;
        });
        
       boolean[] vis = new boolean[n+1];
        
        int min = 0;
        pq.add(new pair(k,-1,0,0));
        
        int noofedges = 0;
        
        
        while(pq.size()!=0)
        {
            pair rem = pq.remove();
            
            if(vis[rem.src] == true) continue;
            
            vis[rem.src] = true;
            if(rem.src != k) noofedges++;
            
            min = Math.max(min, rem.wsf);
            
            for(int[] edge : graph[rem.src])
            {
                if(!vis[edge[0]])
                {
                    pq.add(new pair(edge[0],rem.src,edge[1], rem.wsf + edge[1]));
                }
            }
        }
        
         if(noofedges!=n-1) return -1;
        
        return min == 0 ? -1 : min;
        
        
        
    }
}