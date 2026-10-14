/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     T isreeNode(int val) { this.val = val; }
i *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
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

                      
                                  int res = 0;
                                          Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
                                                  q.offer(new Pair<>(root, Integer.MIN_VALUE));

                                                          while (!q.isEmpty()) {
                                                                      Pair<TreeNode, Integer> pair = q.poll();
                                                                                  TreeNode node = pair.getKey();
                                                                                              int maxval = pair.getValue();
                                                                                                          if (node.val >= maxval) {
                                                                                                                          res++;
                                                                                                                                      }
                                                                                                                                                  if (node.left != null) {
                                                                                                                                                                  q.offer(new Pair<>(node.left, Math.max(maxval, node.val)));
                                                                                                                                                                              }
                                                                                                                                                                                          if (node.right != null) {
                                                                                                                                                                                                          q.offer(new Pair<>(node.right, Math.max(maxval, node.val)));
                                                                                                                                                                                                                      }
                                                                                                                                                                                                                              }
                                                                                                                                                                                                                                      return res;
                                                                                                                                                                                                                                          }
                                                                                                                                                                                                                                          }
    
