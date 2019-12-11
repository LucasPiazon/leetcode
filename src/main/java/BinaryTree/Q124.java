package BinaryTree;

/**
 * @author chelsea
 * @date 2019-12-11
 * 二叉树中的最大路径和
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

//分治法：
//1.根节点最大路径和为 左子树最大路径和，右字树最大路径和，左+右子树连续路径+根 三个最大值
class Q124 {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return maxPathSumHelper(root).maxPath;
    }

    private ResultType maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        ResultType left = maxPathSumHelper(root.left);
        ResultType right = maxPathSumHelper(root.right);
        //如果当前singlepath<0 ,则singlepath=0
        int singlePath = Math.max(left.maxSinglePath < 0 ? 0 : left.maxSinglePath, right.maxSinglePath < 0 ? 0 : right.maxSinglePath) + root.val;
        singlePath = Math.max(singlePath, 0);
        int maxPathSum = Math.max(left.maxPath, right.maxPath);
        maxPathSum = Math.max(maxPathSum, (left.maxSinglePath < 0 ? 0 : left.maxSinglePath) + (right.maxSinglePath < 0 ? 0 : right.maxSinglePath) + root.val);

        return new ResultType(maxPathSum, singlePath);
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;

        Q124 s = new Q124();
        s.maxPathSum(node1);
    }
}

