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
//Recursive DFS:inOrder(left,root,right)
public class Solution {
    int count=0;
    int answer=-1;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return answer;
    }
    private void inorder(TreeNode node,int k){
        if(node==null || count>k){
            return;
        }
        //Visit left subtree
        inorder(node.left,k);
        count++;

        //visit current node
        if(count==k){
            answer=node.val;
            return;
        }

        //Visit right node
        inorder(node.right,k);
    }
}