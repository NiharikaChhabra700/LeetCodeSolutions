class Solution {
    
    public boolean kahns(ArrayList<Integer>[] graph,int n, ArrayList<Integer> ans)
    {
        LinkedList<Integer> que = new LinkedList<>();
        int[] indegree = new int[n];
        
        for(int i=0;i<graph.length;i++)
        {
            for(int vtx : graph[i])
            {
                indegree[vtx]++;
            }
        }
        
        for(int i=0;i<graph.length;i++)
        {
            if(indegree[i] == 0)
            {
                que.addLast(i);
            }
        }
        
        while(que.size()!=0)
        {
            int size = que.size();
            while(size-- > 0)
            {
                int rvtx = que.removeFirst();
                
                ans.add(rvtx);
                
                for(int vtx : graph[rvtx])
                {
                    if(--indegree[vtx] == 0)
                    {
                        que.addLast(vtx);
                    }
                }
            }
        }
        
        return ans.size() == n;
    }
    
    
    
    public boolean canFinish(int n, int[][] prerequisites) {
        
         ArrayList<Integer>[] graph = new ArrayList[n];
        
        for(int i=0;i<n;i++)
        {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] p : prerequisites)
        {
            graph[p[0]].add(p[1]);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        return kahns(graph, n, ans);
        
        
    }
}