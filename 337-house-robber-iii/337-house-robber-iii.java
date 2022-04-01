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
    
    public class housepair{
        int withrobbery=0;
        int withoutrobbery=0;
    }
    
    public housepair rob_(TreeNode root)
    {
        if(root==null) return new housepair();
        
        housepair left=rob_(root.left);
        housepair right=rob_(root.right);
        
        housepair myans=new housepair();
        
        myans.withrobbery=left.withoutrobbery + root.val + right.withoutrobbery;
        myans.withoutrobbery=Math.max(left.withrobbery,left.withoutrobbery)+Math.max(right.withrobbery,right.withoutrobbery);
        
        return myans;
    }
    
    
    public int rob(TreeNode root) {
        housepair ans=rob_(root);
        
        return Math.max(ans.withrobbery,ans.withoutrobbery);
    }
}