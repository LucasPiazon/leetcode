package binarytree;

/**
 * @author chelsea
 * @date 2019-12-02
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }


    /**
     *   4
     *  3   5
     * 1 2   6
     *
     * @return
     */
    public static TreeNode getTree() {
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode4.left = treeNode3;
        treeNode4.right = treeNode5;
        treeNode3.left = treeNode1;
        treeNode3.right = treeNode2;
        treeNode5.right = treeNode6;
        return treeNode4;
    }
}