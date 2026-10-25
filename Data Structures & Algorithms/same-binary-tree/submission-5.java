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
//Optimized Iterative DFS
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode[]> stack=new Stack<>();
        stack.push(new TreeNode[]{p,q});

        while(!stack.isEmpty()){
            TreeNode[] nodes=stack.pop();
            TreeNode node1=nodes[0],node2=nodes[1];

            if(node1==node2) continue;
            if(node1==null || node2==null || node1.val!=node2.val){
                return false;
            }
            stack.push(new TreeNode[]{node1.left,node2.left});
            stack.push(new TreeNode[]{node1.right,node2.right});
        }
        return true;
    }
}
