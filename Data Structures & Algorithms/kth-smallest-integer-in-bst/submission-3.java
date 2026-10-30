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
//Iterative DFS
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;

        while(curr!=null || !stack.isEmpty()){
            //go as far left as possible
            while(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }

            //visit the node
            curr=stack.pop();//pop the top element
            k--;

            if(k==0){
                return curr.val; //return the value at k=0
            }

            //visit the right substree
            curr=curr.right;
        }
        return -1;//return if no answer found
    }
}
