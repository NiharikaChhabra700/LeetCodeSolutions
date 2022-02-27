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
    
    public class pair{
        
        int forwardslope=-1;
        int backwardslope=-1;
        int maxLen=0;
        
    }
    
    
    public pair longestpath(TreeNode root)
    {
        if(root==null)
        {
            return new pair();
        }
        
        pair left=longestpath(root.left);
        pair right=longestpath(root.right);
        
        pair myAns=new pair();
        
        myAns.maxLen= Math.max(Math.max(left.maxLen,right.maxLen),Math.max(left.backwardslope,right.forwardslope)+1);
        
        myAns.forwardslope=left.backwardslope+1;
        myAns.backwardslope=right.forwardslope+1;
        
        return myAns;
    }
    
    
    
    public int longestZigZag(TreeNode root) {
        
        return longestpath(root).maxLen;
        
    }
}