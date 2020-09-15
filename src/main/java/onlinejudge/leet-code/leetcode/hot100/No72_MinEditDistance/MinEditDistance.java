package leetcode.hot100.No72_MinEditDistance;

/**
 * @author Yuan Jiajun
 * @date 2020/9/15 15:43
 * @description @link  https://leetcode-cn.com/problems/edit-distance/
 */
public class MinEditDistance {
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // 有一个字符串为空串
        if (n * m == 0)
            return n + m;

        // DP 数组
        //D[i][j] 表示 A 的前 i 个字母和 B 的前 j 个字母之间的编辑距离
        int[][] D = new int[n + 1][m + 1];

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    D[i][j] = D[i - 1][j - 1];
                }else {
                    int delete = D[i - 1][j] + 1;
                    int insert = D[i][j - 1] + 1;
                    int replace = D[i - 1][j - 1]+1;


                    D[i][j] = Math.min(delete, Math.min(insert, replace));
                }
            }
        }
        return D[n][m];
    }

    public static void main(String[] args) {

        System.out.println(minDistance("intention", "execution"));
    }
}
