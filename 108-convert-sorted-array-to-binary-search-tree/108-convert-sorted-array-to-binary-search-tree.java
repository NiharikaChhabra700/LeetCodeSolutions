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
    
    
    public TreeNode bstconvert(int[] nums,int si,int ei)
    {
        if(si>ei)
        {
            return null;
        }
        
        int mid=(si+ei)/2;
        TreeNode node=new TreeNode(nums[mid]);
        
        node.left=bstconvert(nums,si,mid-1);
        node.right=bstconvert(nums,mid+1,ei);
        
        return node;
    }
    
    
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return bstconvert(nums,0,nums.length-1);
        
        
        
    }
}