class Solution {
    
    public boolean KahnsAlgo(ArrayList<Integer>[] graph, int n){
        
        int[] indegree = new int[n];
        LinkedList<Integer> que = new LinkedList<>();
        
        for(int i = 0; i<n;i++ )
        {
            for(int edge : graph[i])
            {
                indegree[edge]++;
            }
        }
        
        for(int i=0;i<n;i++)
        {
            if(indegree[i] == 0)
            {
                que.addLast(i);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        boolean[] vis = new boolean[n];
        
        while(que.size()!=0)
        {
            int size = que.size();
            while(size-- > 0)
            {
                int rmvtx = que.removeFirst();
                
                ans.add(rmvtx);
                
                
                for(int v : graph[rmvtx])
                {
                    if(--indegree[v] == 0)
                    {
                        que.addLast(v);
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
        
        return KahnsAlgo(graph, n);
        
                                                         
    }
}