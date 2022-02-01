class Solution {
    public int maxProfit(int[] prices) {
         int max=0;
        int min=(int) 1e9;
        
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<min)
            {
                min=Math.min(prices[i],min);
            }
            else
            {
                max=Math.max(max,prices[i]-min);
            }
        }
        
        return max;
        
    }
}