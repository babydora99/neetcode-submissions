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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        dfs(root,0,res);
        return res;
    }    
    private void dfs(TreeNode node,int depth,List<Integer> res){
        if(node==null) return;

        if(depth==res.size()){
            res.add(node.val);
        }
        //visit the right first
        dfs(node.right,depth+1,res);
        //visit the left then
        dfs(node.left,depth+1,res);  
    }  
}
