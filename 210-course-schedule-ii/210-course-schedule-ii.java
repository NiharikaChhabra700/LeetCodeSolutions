class Solution {
     public ArrayList<Integer> kahns(ArrayList<Integer>[] graph,int n)
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
        
        return ans;
        
        
    }
    
    
    public int[] findOrder(int n, int[][] prerequisites) {
          
        ArrayList<Integer>[] graph=new ArrayList[n];
        
        for(int i=0;i<n;i++)
        {
            graph[i]=new ArrayList<>();
        }
        
        for(int[] arr:prerequisites)
        {
            graph[arr[1]].add(arr[0]);
        }
        
        ArrayList<Integer> ans=kahns(graph,n);
        if(ans.size()!=n)
        {
            ans.clear();
            return new int[0];
        }
        
        int[] sol=new int[n];
        
        for(int i=0;i<n;i++)
        {
            sol[i]=ans.get(i);
        }
        
        return sol;
        
        
    }
}