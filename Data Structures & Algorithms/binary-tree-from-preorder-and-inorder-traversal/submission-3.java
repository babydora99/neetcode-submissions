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

//Recursive DFS
public class Solution {
    int preIdx=0;
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //Store inorder values and indexes
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return dfs(preorder,0,inorder.length-1);
    }
    private TreeNode dfs(int[] preorder,int left,int right){
        if(left>right) return null;
        //first preorder element is root
        int rootVal=preorder[preIdx++];
        TreeNode root=new TreeNode(rootVal);
        //find root element position in inorder
        int mid=map.get(rootVal);
        //construct left subtree
        root.left=dfs(preorder,left,mid-1);
        //construct right subtree
        root.right=dfs(preorder,mid+1,right);

        return root;
    }
}