package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chelsea
 * @date 2019-12-04
 * <p>
 * 二叉树的后序遍历
 */
public class Q145 {

    //1.递归
    private void postorderTraversalHelper(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        postorderTraversalHelper(node.left, res);
        postorderTraversalHelper(node.right, res);
        res.add(node.val);
    }

    //2.divide and conquer
    private List<Integer> postorderTraversalHelper2(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        List<Integer> leftRes = postorderTraversalHelper2(node.left);
        List<Integer> rightRes = postorderTraversalHelper2(node.right);
        res.addAll(leftRes);
        res.addAll(rightRes);
        res.add(node.val);
        return res;
    }

    //3.stack
    private List<Integer> postorderTraversalHelper3(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null; // previously traversed node
        TreeNode curr = root;

        if (root == null) {
            return result;
        }

        stack.push(root);
        while (!stack.empty()) {
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) { // traverse down the tree
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) { // traverse up the tree from the left
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else { // traverse up the tree from the right
                result.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }

        return result;
    }
}
