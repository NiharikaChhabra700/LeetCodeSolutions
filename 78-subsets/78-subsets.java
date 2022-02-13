class Solution {
    public void dfs(int[] nums,List<Integer> smallans,int i,List<List<Integer>> res)
    {
        if(i==nums.length)
        {
            res.add(new ArrayList(smallans));
            return;
        }
        
        smallans.add(nums[i]);
        dfs(nums,smallans,i+1,res);  //taking an element
        smallans.remove(smallans.size()-1);
        dfs(nums,smallans,i+1,res);   //not taking an element;
    }
    
    
    
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res=new ArrayList();
        dfs(nums,new ArrayList<>(),0,res);
        
        return res;
        
    }
}