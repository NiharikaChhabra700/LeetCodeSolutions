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
    
    public void pathsum(TreeNode root,int target,List<Integer> smallans,List<List<Integer>> ans)
    {
        if(root==null)
        {
            return;
        }
        if(root.left==null && root.right==null)
        {
            if(root.val-target==0)
            {
                List<Integer> base=new ArrayList<>(smallans);
                base.add(root.val);
                ans.add(base);
            }
            return;
        }
        
        smallans.add(root.val);
        
        pathsum(root.left,target-root.val,smallans,ans);
        pathsum(root.right,target-root.val,smallans,ans);
        
        smallans.remove(smallans.size()-1);
        
    }
    
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null)
        {
            return new ArrayList<>();
        }
       List<List<Integer>> ans=new ArrayList<>();

        pathsum(root,targetSum,new ArrayList<>(),ans);
        
        return ans;
        
    }
}