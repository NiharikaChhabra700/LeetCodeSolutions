class Solution {
    
    public boolean Kahns(ArrayList<Integer>[] graph , int n)
    {
        int[] indegree = new int[n];
        
        for(int i=0;i<n;i++)
        {
            for(int e : graph[i])
            {
                indegree[e]++;
            }
        }
        
        LinkedList<Integer> que = new LinkedList<>();
        
        for(int i=0;i<n;i++)
        {
            if(indegree[i] == 0)
            {
                que.addLast(i);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(que.size()!=0)
        {
            int size=que.size();
            while(size-- > 0)
            {
                int rvtx = que.removeFirst();
                ans.add(rvtx);
                
                for(int e : graph[rvtx])
                {
                    if(--indegree[e] == 0)
                    {
                        que.addLast(e);
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
            graph[i]=new ArrayList<>();
        }
        for(int[] arr : prerequisites)
        {
            graph[arr[0]].add(arr[1]);
        }
        
        return Kahns(graph,n);
        
        
        
    }
}