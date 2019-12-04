package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chelsea
 * @date 2019-12-04
 * <p>
 * 二叉树的后序遍历
 */
public class Q145 {

    //递归
    private void postorderTraversalHelper(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        postorderTraversalHelper(node.left, res);
        postorderTraversalHelper(node.right, res);
        res.add(node.val);
    }

    //divide and conquer
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
}
