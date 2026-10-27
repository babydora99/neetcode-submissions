

class Solution {
    static class Pair {
        TreeNode p, q;

        Pair(TreeNode p, TreeNode q) {
            this.p = p;
            this.q = q;
        }
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.val == subRoot.val &&
                isSameTree(node, subRoot)) {
                return true;
            }

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return false;
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(p, q));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode a = pair.p;
            TreeNode b = pair.q;

            if (a == null && b == null) continue;

            if (a == null || b == null || a.val != b.val) {
                return false;
            }

            queue.offer(new Pair(a.left, b.left));
            queue.offer(new Pair(a.right, b.right));
        }

        return true;
    }
}
