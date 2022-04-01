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
    
    
    int lc,rc;
    
    public int count(TreeNode root,int x)
    {
        if(root==null) return 0;
        
        int left=count(root.left,x);
        int right=count(root.right,x);
        
        if(root.val==x)
        {
            lc=left;
            rc=right;
        }
        
        return left+right+1;
    }
    
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        
        lc=0;
        rc=0;
        
        count(root,x);
        
        int parentnodes= n-(lc+rc+1);
        
        int max=Math.max(Math.max(lc,rc),parentnodes);
        
        return max > n/2;
        
    }
}