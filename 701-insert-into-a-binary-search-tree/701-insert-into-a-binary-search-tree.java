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
        TreeNode prev=null;
        
        while(curr!=null)
        {
            if(val<curr.val)
            {
                prev=curr;
                curr=curr.left;
            }
            else if(val>curr.val)
            {
                prev=curr;
                curr=curr.right;
            }
        }
        TreeNode ans=new TreeNode(val);
        
        if(prev==null) return ans;
        
        else if(val<prev.val)
        {
            prev.left=ans;
        }
        else if(prev.val<val)
        {
            prev.right=ans;
        }
        return root;
        
    }
}