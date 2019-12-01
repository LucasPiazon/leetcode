package BinaryTree;

/**
 * @author chelsea
 * @date 2019-12-01
 * 二叉搜索树中第K小的元素
 */
public class Q230 {

    public static void main(String[] args) {
        Solution.TreeNode node3 = new Solution.TreeNode(3);
        Solution.TreeNode node1 = new Solution.TreeNode(1);
        Solution.TreeNode node4 = new Solution.TreeNode(4);
        Solution.TreeNode node2 = new Solution.TreeNode(2);
        node3.left = node1;
        node3.right = node4;
        node1.right = node2;
        Solution solution = new Solution();
        solution.kthSmallest(node3, 1);
    }

    static class Solution {
        private int value = 0;
        private int i = 0;

        public int kthSmallest(TreeNode root, int k) {
            kthSmallestHelper(root, k);
            return value;
        }

        private void kthSmallestHelper(TreeNode node, int k) {
            if (node == null || i == k) {
                return;
            }
            kthSmallestHelper(node.left, k);
            if (++i == k) {
                value = node.val;
            }
            kthSmallestHelper(node.right, k);
        }

        static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) { val = x; }
        }
    }
}
