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
    ArrayList<Integer> list;
    public boolean isValidBST(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
        for(int i=0;i<list.size()-1;i++){
            int a = list.get(i);
            int b = list.get(i+1);
            if(a>=b) return false;
        }
        return true;
    }
    private void dfs(TreeNode node){
        if(node==null) return;
        if(node.left!=null){
            dfs(node.left);
        }
        list.add(node.val);
        if(node.right!=null){
            dfs(node.right);
        }
    }
}