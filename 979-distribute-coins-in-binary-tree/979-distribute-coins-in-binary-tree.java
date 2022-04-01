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
        
        int lc=distribute(root.left); // how much do you need or got extra
        int rc=distribute(root.right);  // how much do you need or got extra
        
        steps += Math.abs(lc) + Math.abs(rc);
        
        return (lc + rc + root.val -1);
    }
    
    
    public int distributeCoins(TreeNode root) {
        
        distribute(root);
        
        return steps;
    }
}