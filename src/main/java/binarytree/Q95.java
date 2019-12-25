package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chelsea
 * @date 2019-12-25
 * <p>
 * 不同的二叉搜索树 II
 * 分治
 * 当前根节点的二叉树=左子树二叉树的-根-右子树的二叉树
 */
public class Q95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTreesHelper(1, n);
    }

    //树的根节点列表
    public List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);
            return trees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTreesHelper(start, i - 1);
            List<TreeNode> right = generateTreesHelper(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode tree = new TreeNode(i);
                    tree.left = l;
                    tree.right = r;
                    trees.add(tree);
                }
            }
        }
        return trees;
    }
}
