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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        TreeNode curr=root;
        TreeNode prev=curr;
        
        while(curr!=null)
        {
            prev=curr;
            if(curr.val<val)
            {
                curr=curr.right;
            }
            else
            {
                curr=curr.left;
            }
        }
        
        TreeNode node=new TreeNode (val);
        
        if(prev==null) return node;
        
        if(val>prev.val)
        {
            prev.right=node;
        }
        else
        {
            prev.left=node;
        }
        
        return root;
        
    }
}