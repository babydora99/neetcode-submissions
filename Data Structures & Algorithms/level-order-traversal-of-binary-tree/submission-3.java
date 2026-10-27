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
//DFS
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root,0);
        return res;
    }
    private void dfs(TreeNode node,int depth){
        if(node==null) return;
        if(res.size()==depth){
            res.add(new ArrayList<>());
        }
        res.get(depth).add(node.val);
        dfs(node.left,depth+1);
        dfs(node.right,depth+1);
    }
}
