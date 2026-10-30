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
//BFS ->(Queue+MaxHeap)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        //Max-Heap
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        while(!q.isEmpty()){
            TreeNode node=q.poll();

            pq.offer(node.val);
            if(pq.size()>k){
                pq.poll();
            }

            if(node.left!=null){
                q.offer(node.left);
            }
            if(node.right!=null){
                q.offer(node.right);
            }
        }
        return pq.peek();
    }
}
