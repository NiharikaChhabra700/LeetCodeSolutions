class Solution {
    public int findMaxLength(int[] arr) {
        
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int len=0,sum=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0)
            {
                sum+=-1;
            }
            else
            {
                sum+=1;
            }
            if(map.containsKey(sum))
            {
                int idx=map.get(sum);
                len=Math.max(len,i-idx);
            }
            else
            {
                map.put(sum,i);
            }
        }
        
        return len;
        
    }
}