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
    int steps=0;
    
    public int distribute(TreeNode root)
    {
        if(root==null) return 0;
        
        int lc=distribute(root.left);
        int rc=distribute(root.right);
        
        steps += Math.abs(lc) + Math.abs(rc);
        
        return (lc + rc + root.val -1);
    }
    
    
    public int distributeCoins(TreeNode root) {
        
        distribute(root);
        
        return steps;
    }
}