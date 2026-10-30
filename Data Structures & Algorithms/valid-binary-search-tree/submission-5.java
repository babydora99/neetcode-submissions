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
//BFS - Queue
class Solution {
    class QueueTree{
        TreeNode node;
        long min;
        long max;

        QueueTree(TreeNode node,long min,long max){
            this.node=node;
            this.min=min;
            this.max=max;
        }
    }
    public boolean isValidBST(TreeNode root) {
        Queue<QueueTree> q=new LinkedList<>();
        q.offer(new QueueTree(root,Long.MIN_VALUE,Long.MAX_VALUE));
        while(!q.isEmpty()){
            QueueTree curr=q.poll();
            TreeNode node=curr.node;

            if(node.val<=curr.min || node.val>=curr.max){
                return false;
            }
            if(node.left!=null){
                q.offer(new QueueTree(node.left,curr.min,node.val));
            }
            if(node.right!=null){
                q.offer(new QueueTree(node.right,node.val,curr.max));
            }
        }
        return true;
    }
}
