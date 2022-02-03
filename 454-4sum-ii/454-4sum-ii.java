class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
         HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int el1:nums1)
        {
            for(int el2: nums2)
            {
                map.put(el1+el2,map.getOrDefault(el1+el2,0)+1);
            }
        }
        
        int count=0,tar=0;
        for(int ele1:nums3)
        {
            for(int ele2:nums4)
            {
                if(map.containsKey(tar-(ele1+ele2)))
                {
                    count+=map.get(tar-(ele1+ele2));
                }
            }
        }
        
        return count;
        
    }
}