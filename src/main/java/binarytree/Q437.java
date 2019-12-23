package binarytree;

/**
 * @author chelsea
 * @date 2019-12-09
 * <p>
 * 路径总和 III
 */
public class Q437 {

    private int count;

    public int pathSum(TreeNode root, int sum) {
        preOrder(root, sum);
        return count;
    }

    private void preOrder(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        pathSumHelper(node, sum);
        preOrder(node.left, sum);
        preOrder(node.right, sum);
    }

    private void pathSumHelper(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        sum -= node.val;
        if (sum == 0) {
            count++;
        }
        pathSumHelper(node.left, sum);
        pathSumHelper(node.right, sum);
    }
}
