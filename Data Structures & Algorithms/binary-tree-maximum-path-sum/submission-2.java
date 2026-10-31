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
//DFS
class Solution {
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
    private int dfs(TreeNode node){
        if(node==null) return 0;
        //ignore negative path Contribution
        int left=Math.max(0,dfs(node.left));
        int right=Math.max(0,dfs(node.right));
        //Max path passing through current node
        int currSum=node.val+left+right;
        //Update Global sum
        maxSum=Math.max(maxSum,currSum);
        //Return one-sided path to parent(Downward Path)
        return node.val+Math.max(left,right);
    }
}
