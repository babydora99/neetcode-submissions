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
    public int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode,int[]> map=new HashMap<>();
        map.put(null,new int[]{0,0});
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.peek();
            if(node.left!=null && !map.containsKey(node.left)){
                stack.push(node.left);
            }else if(node.right!=null && !map.containsKey(node.right)){
                stack.push(node.right);
            }
            else{
                node=stack.pop();
                int[] leftData=map.get(node.left);
                int[] rightData=map.get(node.right);
                int leftHeight=leftData[0],leftDiameter=leftData[1];
                int rightHeight=rightData[0],rightDiameter=rightData[1];
                int height=1+Math.max(leftHeight,rightHeight);
                int diameter=Math.max(leftHeight+rightHeight,Math.max(leftDiameter,rightDiameter));
                map.put(node,new int[]{height,diameter});
            }
        }
        return map.get(root)[1];

    }
}
