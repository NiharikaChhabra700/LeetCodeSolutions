class Solution {
    
    public boolean ispossible(int[] piles,int h,int sp)
    {
        int time=0;
        for(int i=0;i<piles.length;i++)
        {
          time+=(int)(Math.ceil(piles[i]*1.0/sp));  
        }
        
        return time<=h;
    }
    
    
    
    
    
    public int minEatingSpeed(int[] piles, int h) {
        
        int max=Integer.MIN_VALUE;
        
        for(int val:piles)
        {
            max=Math.max(val,max);
        }
        
        if(h==piles.length)
        {
            return max;
        }
        
        int hi=max;
        int lo=0;
        int speed=Integer.MAX_VALUE;
        
        while(lo<=hi)
        {
            int sp=lo+(hi-lo)/2;
            
            if(ispossible(piles,h,sp)== true)
            {
                speed=sp;
                hi=sp-1;
            }
            else
            {
                lo=sp+1;
            }
        }
        
        
        return speed;
    }
}