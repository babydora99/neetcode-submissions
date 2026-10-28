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
    public int goodNodes(TreeNode root) {
        Stack<TreeNode> nodes=new Stack<>();
        Stack<Integer> maxValues=new Stack<>();

        nodes.push(root);
        maxValues.push(root.val);

        int count=0;
        while(!nodes.isEmpty()){
            TreeNode node=nodes.pop();
            Integer maxVal=maxValues.pop();
            if(node.val>=maxVal){
                count+=1;
            }
            maxVal=Math.max(maxVal,node.val);
            if(node.left!=null){
                nodes.push(node.left);
                maxValues.push(maxVal);
            }
            if(node.right!=null){
                nodes.push(node.right);
                maxValues.push(maxVal);
            }
        }
        return count;
    }
}
