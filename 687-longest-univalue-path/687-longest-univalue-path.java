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
    
    int max=0;
    
    public int longest(TreeNode root)
    {
        if(root==null)
         return -1;
        if(root.left==null&&root.right==null)
         return 0;
        
        int lc=longest(root.left);
        int rc=longest(root.right);
        
        int lans=0,rans=0;
        
        if(root.left!=null && root.left.val==root.val)
        {
            lans=lc+1;
        }
        
        if(root.right!=null && root.right.val==root.val)
        {
            rans=rc+1;
        }
        
        int ans=Math.max(rans,lans);
        max=Math.max(max,lans+rans);
        
        return ans;
        
        
    }
    
    
    
    public int longestUnivaluePath(TreeNode root) {
        
        longest(root);
        return max;
    }
}