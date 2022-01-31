class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int max=-(int)1e9+7;
    
        for(int[] account:accounts)
        {
            int currwealth=0;
            for(int money:account)
            {
                currwealth+=money;
            }
            
            if(currwealth>max)
            {
                max=currwealth;
            }
        }
        
        return max;
        
    }
}