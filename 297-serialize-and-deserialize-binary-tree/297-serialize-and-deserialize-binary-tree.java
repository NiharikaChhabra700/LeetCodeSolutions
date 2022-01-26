/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

   public String serialize(TreeNode root) {
    if(root == null){
        return "";
    }
    
    return dfs(root);
}

StringBuilder sb = new StringBuilder();
public String dfs(TreeNode node){
    if(node == null){
        sb.append("null, ");
        return "";
    }
    
    sb.append(node.val + ", ");
    
    dfs(node.left);
    dfs(node.right);
    
    return sb.toString();
}



// Decodes your encoded data to tree.
public TreeNode deserialize(String data) {
    if(data.equals("")){
        return null;
    }
    String arr[] = data.split(", ");
    return construct(arr);
}

int idx = 0;
public TreeNode construct(String arr[]){
    if(idx >= arr.length || arr[idx].equals("null")){
        idx++;
        return null;
    }
    
    TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
    node.left = construct(arr);
    node.right = construct(arr);
    
    return node;
}
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));