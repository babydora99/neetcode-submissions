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
//Recursive DFS
class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root,root.val);
    }
    private int dfs(TreeNode node,int maxVal){
        if(node==null) return 0;
        int count=0;
        if(node.val>=maxVal) count++;
        maxVal=Math.max(node.val,maxVal);
        
        count+=dfs(node.left,maxVal);
        count+=dfs(node.right,maxVal);
        return count;
    }
}
