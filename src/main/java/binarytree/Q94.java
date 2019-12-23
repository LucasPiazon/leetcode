package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chelsea
 * @date 2019-12-02
 * <p>
 * 二叉树的中序遍历
 * traverse 与divide and conquer的区别
 * 1.入参与返回值
 * 2.思维方式
 */
public class Q94 {

    static class Solution {
        //1.traverse
        public List<Integer> inorderTraversal(TreeNode root) {
            return inorderTraversalHelper3(root);
        }

        private void inorderTraversalHelper1(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            inorderTraversalHelper1(root.left, res);
            res.add(root.val);
            inorderTraversalHelper1(root.right, res);
        }

        //2.divide and conquer
        private List<Integer> inorderTraversalHelper2(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            List<Integer> left = inorderTraversalHelper2(root.left);
            List<Integer> right = inorderTraversalHelper2(root.right);

            res.addAll(left);
            res.add(root.val);
            res.addAll(right);
            return res;
        }

        //3.stack
        //1.一次将所有左节点压入栈 2.弹出一个节点 3.将该节点的右节点以及右节点的所有左节点压入栈
        private List<Integer> inorderTraversalHelper3(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> list = new ArrayList<>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            while (!stack.empty()) {
                TreeNode curr = stack.pop();
                list.add(curr.val);
                if (curr.right != null) {
                    TreeNode node = curr.right;
                    while (node != null) {
                        stack.push(node);
                        node = node.left;
                    }
                }
            }
            return list;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.inorderTraversal(TreeNode.getTree());
    }
}
