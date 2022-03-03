class Solution {
    
    public class pair{
        
        int val;
        int gap;
        
        pair(){
            
        }
        
        pair(int val,int gap)
        {
            this.val=val;
            this.gap=gap;
        }
    }
    
    
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        PriorityQueue<pair> que=new PriorityQueue<>((a,b)->{
            if(a.gap != b.gap)
            {
                return b.gap-a.gap;
            }
            else
            {
                return a.val-b.val;
            }
        });
        
        for(int i=0;i<arr.length;i++)
        {
            if(que.size()<k)
            {
                que.add(new pair(arr[i],Math.abs(arr[i]-x)));
            }
            else
            {
                if(que.peek().gap > Math.abs(arr[i]-x))
                {
                    que.remove();
                    que.add(new pair(arr[i],Math.abs(arr[i]-x)));
                }
            }
        }
        
        List<Integer> ans=new ArrayList<>();
        while(que.size()!=0)
        {
            pair rm=que.remove();
            ans.add(rm.val);
        }
        
        Collections.sort(ans);
        return ans;
        
    }
}