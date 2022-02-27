/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int total=0;
    
    
    
    public void pathsum(TreeNode root,int sum,int target,HashMap<Integer,Integer> map)
    {
        if(root==null)
        {
            return;
        }
        
        sum+=root.val;
        if(map.containsKey(sum-target))
        {
            total+=map.get(sum-target);
        }
        map.put(sum,map.getOrDefault(sum,0)+1);
        
        pathsum(root.left,sum,target,map);
        pathsum(root.right,sum,target,map);
        
        map.put(sum,map.get(sum)-1);
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)
        {
            return 0;
        }
        
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        
        pathsum(root,0,targetSum,map);
        return total;
    }
    
    
    
}