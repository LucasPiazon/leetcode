package binarytree;

/**
 * @author chelsea
 * @date 2019-12-12
 * <p>
 * 二叉搜索树中的插入操作
 */
public class Q701 {

    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return root;
            }
            insertIntoBSTHelper(root, val);
            return root;
        }

        private void insertIntoBSTHelper(TreeNode node, int val) {
            if (node == null) {
                return;
            }
            if (val > node.val) {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return;
                }
                insertIntoBSTHelper(node.right, val);
            } else {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return;
                }
                insertIntoBSTHelper(node.left, val);
            }
        }
    }

}

