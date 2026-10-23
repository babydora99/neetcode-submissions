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
//Brute Force
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int leftHeight=maxHeight(root.left);
        int rightHeight=maxHeight(root.right);
        int diameter=leftHeight+rightHeight;
        int res=Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right));
        return Math.max(diameter,res);
    }
    public int maxHeight(TreeNode root){
        if(root==null) return 0;

        return 1+Math.max(maxHeight(root.left),maxHeight(root.right));
    }
}
