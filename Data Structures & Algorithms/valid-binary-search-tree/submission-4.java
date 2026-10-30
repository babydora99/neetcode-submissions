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
//Iterative DFS - Stack
class Solution {
    class NodeInfo{
        TreeNode node;
        long min;
        long max;

        NodeInfo(TreeNode node,long min,long max){
            this.node=node;
            this.min=min;
            this.max=max;
        }
    }
    public boolean isValidBST(TreeNode root) {
        Stack<NodeInfo> stack=new Stack<>();
        stack.push(new NodeInfo(root,Long.MIN_VALUE,Long.MAX_VALUE));

        while(!stack.isEmpty()){
            NodeInfo curr=stack.pop();
            TreeNode node=curr.node;
            if(node.val<=curr.min || node.val>=curr.max){
                return false;
            }
            if(node.left!=null){
                stack.push(new NodeInfo(node.left,curr.min,node.val)); 
            }
            if(node.right!=null){
                stack.push(new NodeInfo(node.right,node.val,curr.max));
            }
        }
        return true;
    }
}
