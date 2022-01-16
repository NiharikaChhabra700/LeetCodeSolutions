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
    int min;
	int ans = -1;

	public int findSecondMinimumValue(TreeNode root) {
		min = root.val;
		helper(root);
		return ans;
	}

	void helper(TreeNode root){
		if(root==null) return;  // base case
		if(ans!=-1 && root.val>ans) return;  // avoid extra calls.

		check(root.val);
		helper(root.left);
		helper(root.right);
	}

	void check(int x){
		if(ans==-1 && x!=min)
			ans = x;
		else if(x<ans && min<x)
			ans = x;
	}
}