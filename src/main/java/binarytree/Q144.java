package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chelsea
 * @date 2019-12-04
 * <p>
 * 二叉树的前序遍历
 */
class Q144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversalHelper(root, res);
        return res;
    }

    //递归
    private void preorderTraversalHelper(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        preorderTraversalHelper(node.left, res);
        preorderTraversalHelper(node.right, res);
    }

    //divide and conquer
    private List<Integer> preorderTraversalHelper1(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        res.add(node.val);
        List<Integer> leftRes = preorderTraversalHelper1(node.left);
        List<Integer> rightRes = preorderTraversalHelper1(node.right);
        res.addAll(leftRes);
        res.addAll(rightRes);
        return res;
    }

    //stack
    private List<Integer> preorderTraversalHelper2(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (node == null) {
            return res;
        }
        stack.push(node);
        while (!stack.empty()) {
            TreeNode treeNode = stack.pop();
            res.add(treeNode.val);
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
        return res;
    }
}
