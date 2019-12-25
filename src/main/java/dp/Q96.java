package dp;

/**
 * @author chelsea
 * @date 2019-12-24
 * <p>
 * 不同的二叉搜索树：给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 卡特兰数：G(n+1)=G(1)*G(n)+G(2)*G(n-2)+...+G(1)*G(n)
 * 设G(n)为n个节点的二叉搜索树的个数，f(i)表示以i为根节点的二叉搜索树的个数
 * G(n)=f(1)+f(2)+f(3)+...+f(n)
 * f(i)=G(i-1)*G(n-i)(左子树的种类*右子树的种类)
 * G(n)=sum{G(i-1)*G(n-i)}(1<=i<=n-1)
 * <p>
 * 1.g(i)i个数组成的二叉平衡树的个数
 * 2.g(i)=g(j)*g(i-j-1)(0<=j<=j-1)
 */
public class Q96 {

    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        int[] g = new int[n + 1];
        g[0] = 1;
        g[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                g[i] += g[j] * g[i - j - 1];
            }
        }
        return g[n];
    }
}
