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
    
    public int idx=0;
    
    public TreeNode construct(int[] preorder,int lr,int rr)
    {
        if(idx>=preorder.length || preorder[idx] < lr || preorder[idx]> rr )
        {
            return null;
        }
        
        TreeNode root=new TreeNode(preorder[idx++]);
        
        root.left=construct(preorder,lr,root.val);
        root.right=construct(preorder,root.val,rr);
        
        return root;
    }
    
    
    public TreeNode bstFromPreorder(int[] preorder) {
        
        int lr=-(int)1e9+7;
        int rr=(int)1e9+7;
        
        return construct(preorder,lr,rr);
        
    }
}