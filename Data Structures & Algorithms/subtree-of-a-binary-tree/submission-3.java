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
    static class Pair{
        TreeNode p,q;
        Pair(TreeNode p,TreeNode q){
            this.p=p;
            this.q=q;
        }
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Deque<TreeNode> stack=new ArrayDeque<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node.val == subRoot.val && isSameTree(node,subRoot)){
                return true;
            }
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
        return false;
    }
    private boolean isSameTree(TreeNode p,TreeNode q){
        Deque<Pair> stack=new ArrayDeque<>();
        stack.push(new Pair(p,q));

        while(!stack.isEmpty()){
            Pair pair=stack.pop();
            TreeNode a=pair.p;
            TreeNode b=pair.q;

            if(a==null && b==null) continue;
            if(a==null || b==null || a.val!=b.val){
                return false;
            }
            stack.push(new Pair(a.left,b.left));
            stack.push(new Pair(a.right,b.right));
        }
        return true;

    }
}
