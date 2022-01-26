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
    
    List<Integer> ans;
    
    public void getlist(TreeNode root)
    {
        if(root==null) return;
        
        ans.add(root.val);
        getlist(root.left);
        getlist(root.right);
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        
        ans=new ArrayList<>();
        getlist(root1);
        getlist(root2);
        
        Collections.sort(ans);
        return ans;
        
    }
}