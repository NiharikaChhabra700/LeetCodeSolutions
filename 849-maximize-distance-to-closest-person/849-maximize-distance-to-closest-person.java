class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int idx1=-1,idx2=-1,n=seats.length;
        int empty=0,res=0;
        
        for(int i=0;i<seats.length;i++)
        {
            if(seats[i]==1)
            {
                empty=0;
                if(idx1==-1)
                {
                    idx1=i;
                }
                idx2=i;
            }
            else
            {
                empty++;
                res=Math.max(res,(empty+1)/2);
            }
        }
        
        res=Math.max(res,Math.max(idx1,n-idx2-1));
        return res;
        
    }
}