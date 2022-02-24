class Solution {
    
    public boolean kahns(ArrayList<Integer>[] graph,int n)
    {
        int[] indegree=new int[n];
        
        for(ArrayList<Integer> arr: graph)
        {
            for(int v: arr)
            {
                indegree[v]++;
            }
        }
        
        LinkedList<Integer> que=new LinkedList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0) que.addLast(i);
        }
        
        while(que.size()!=0)
        {
            int size=que.size();
            while(size-->0)
            {
                int rvtx=que.removeFirst();
                ans.add(rvtx);
                
                for(int v: graph[rvtx])
                {
                    if(--indegree[v]==0)
                    {
                        que.addLast(v);
                    }
                }
            }
            
        }
        
        return ans.size()==n;
        
        
    }
    
    
    
    
    
    public boolean canFinish(int n, int[][] prerequisites) {
        
        ArrayList<Integer>[] graph=new ArrayList[n];
        
        for(int i=0;i<n;i++)
        {
            graph[i]=new ArrayList<>();
        }
        
        for(int[] arr:prerequisites)
        {
            graph[arr[0]].add(arr[1]);
        }
        
        return kahns(graph,n);
        
    }
}