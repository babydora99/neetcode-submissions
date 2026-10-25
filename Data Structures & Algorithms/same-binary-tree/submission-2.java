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
//BFS 
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while(!queue.isEmpty()){
            TreeNode nodeP=queue.poll();
            TreeNode nodeQ=queue.poll();
            if(nodeP==nodeQ) continue;
            if(nodeP==null || nodeQ==null || nodeP.val!=nodeQ.val){
                return false;
            }

            queue.offer(nodeP.left);
            queue.offer(nodeQ.left);
            queue.offer(nodeP.right);
            queue.offer(nodeQ.right);
            
        }
        return true;
    }
}