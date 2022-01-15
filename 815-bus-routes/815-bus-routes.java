class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        
        for(int i=0;i<routes.length;i++)
        {
            for(int j=0;j<routes[i].length;j++)
            {
                int bustopno=routes[i][j];
                ArrayList<Integer> busno=map.getOrDefault(bustopno,new ArrayList<>());
                busno.add(i);
                map.put(bustopno,busno);
            }
        }
        
        LinkedList<Integer> que=new LinkedList<>();
        HashSet<Integer> busvis=new HashSet<>();
        HashSet<Integer> busStopvis=new HashSet<>();
        que.addLast(source);
        int level=0;
        
        while(que.size()!=0)
        {
            int size=que.size();
            while(size-->0)
            {
                int rem=que.removeFirst();
                
                if(rem==target)
                {
                    return level;
                }
                
                ArrayList<Integer> buses=map.get(rem);
                for(int bus:buses)
                {
                    if(busvis.contains(bus)==true) continue;
                    
                    int[] arr=routes[bus];
                    for(int busstop : arr)
                    {
                        if(busStopvis.contains(busstop)==true) continue;
                        
                        que.addLast(busstop);
                        busStopvis.add(busstop);
                        
                    }
                    
                    busvis.add(bus);
                }
            }
            
            level++;
        }
        
        return -1;
        
    }
}