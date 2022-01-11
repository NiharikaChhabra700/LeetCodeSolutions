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
    
    
    int totalSum=0;
    
    public void dfs(TreeNode root,int currSum)
    {
        if(root==null)
        {
            return;
        }
        
        currSum+=root.val;
        
        if(root.left==null && root.right==null)
        {
            totalSum+=currSum;
            return;
        }
        
        dfs(root.left,currSum*2);
        dfs(root.right,currSum*2);
    }
    
    public int sumRootToLeaf(TreeNode root) {
        
        if(root==null) return 0;
        
        dfs(root,0);
        
        return totalSum;
        
    }
}