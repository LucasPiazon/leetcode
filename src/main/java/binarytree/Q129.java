package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chelsea
 * @date 2019-12-09
 * <p>
 * 求根到叶子节点数字之和
 */
public class Q129 {

    private int count;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<String> res = new ArrayList<>();
        sumNumbersHelper(root, res, "");
        return res.stream().mapToInt(Integer::valueOf).boxed().reduce(Integer::sum).orElse(0);
    }

    private void sumNumbersHelper(TreeNode root, List<String> res, String str) {
        if (root == null) {
            return;
        }
        str += root.val;
        if (root.left == null && root.right == null) {
            res.add(str);
            return;
        }
        sumNumbersHelper(root.left, res, str);
        sumNumbersHelper(root.right, res, str);
    }
}
