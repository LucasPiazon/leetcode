package binarytree;

/**
 * @author chelsea
 * @date 2019-12-12
 * <p>
 * 删除二叉搜索树中的节点
 */
public class Q450 {

    class Solution {
        TreeNode temp;
        TreeNode pre;

        public TreeNode deleteNode(TreeNode root, int key) {
            temp = new TreeNode(Integer.MIN_VALUE);
            temp.right = root;
            pre = temp;
            deleteNodeHelper(root, key);
            return temp.right;
        }

        private void deleteNodeHelper(TreeNode root, int key) {
            if (root == null) {
                return;
            }
            if (key == root.val) {
                if (root.left != null) {
                    //循环获取左子树的最大节点
                    TreeNode leftMax = root.left;
                    while (leftMax.right != null) {
                        leftMax = leftMax.right;
                    }
                    if (key > pre.val) {
                        pre.right = leftMax;
                    } else {
                        pre.left = leftMax;
                    }
                }
                if (root.right != null) {
                    if (key > pre.val) {
                        pre.right = root.right;
                    } else {
                        pre.left = root.right;
                    }
                }
                if (pre.val == Integer.MIN_VALUE) {
                    temp.right = pre.right;
                }
            } else if (key > root.val) {
                pre = root;
                deleteNodeHelper(root.right, key);
            } else {
                pre = root;
                deleteNodeHelper(root.left, key);
            }
        }
    }
}
