package upup.com.oj.company.huawei.xiaozhao.test2;

import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @date 2020/9/6 18:14
 * @description @link https://segmentfault.com/a/1190000023927124
 * 输入：源字符串；目标字符串
 * 每个字符串包括多个单词，以一个或多个空格分割，比较时不区分大小写
 * 符号中，逗号 ， 句号 . 叹号 ! 互相视为相同，而 问号 ？ 与其他符号不同，符号偏差规则与单词偏差规则相同
 * 数字与字母处理方式一样，与字母无空格分隔视为一个单词，否则视为多个单词。
 * <p>
 * 输出：
 * 输出偏差与目标字符串单词总数
 */
public class Main3Pass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = s.split(";")[0].replaceAll("[.!,]", " .").replaceAll("\\?", " ?");
        String s2 = s.split(";")[1].replaceAll("[.!,]", " .").replaceAll("\\?", " ?");
        ;

//        String s1 = "This is a book.";
//        String s2 = "This is a book.";

        String[] stringArray1 = s1.split(" ");
        String[] stringArray2 = s2.split(" ");

        int step = 0;
        int totalLen = stringArray2.length;


        step = minDistance(stringArray1, stringArray2);
        System.out.println("(" + step + "," + totalLen + ")");
    }

    public static int minDistance(String[] stringArray1, String[] stringArray2) {
        int n = stringArray1.length;
        int m = stringArray2.length;

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
                if (stringArray1[i - 1].equals(stringArray2[j - 1])) {
                    D[i][j] = D[i - 1][j - 1];
                } else {
                    int delete = D[i - 1][j] + 1;
                    int insert = D[i][j - 1] + 1;
                    int replace = D[i - 1][j - 1] + 2;
                    D[i][j] = Math.min(delete, Math.min(insert, replace));
                }
            }
        }
        return D[n][m];
    }

}