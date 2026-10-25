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
//Iterative DFS->explicitly use stack
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack=new Stack<>();
        stack.push(p);
        stack.push(q);

        while(!stack.isEmpty()){
            TreeNode nodeP=stack.pop();
            TreeNode nodeQ=stack.pop();
            if(nodeP==nodeQ) continue;
            if(nodeP==null || nodeQ==null || nodeP.val!=nodeQ.val){
                return false;
            }
            stack.push(nodeP.left);
            stack.push(nodeQ.left);
            stack.push(nodeP.right);
            stack.push(nodeQ.right);

        }
        return true;
    }
}
