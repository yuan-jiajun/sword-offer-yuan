package upup.com.oj.company.meituan.turn1;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @date 2020/9/6 10:16
 * @description
 * https://www.nowcoder.com/discuss/500649
 * 给出A，B两国想要的土地，输出只有A国想要的土地数，只有B国想要的土地数，两个国家都想要的土地数。
 * ac100
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        int numTotal = sc.nextInt();
        int numA = sc.nextInt();
        int numB = sc.nextInt();
        while (numA-- > 0) {
            set1.add(sc.nextInt());
        }
        while (numB-- > 0) {
            int temp = sc.nextInt();
            if (set1.contains(temp)) {
                set.add(temp);
            }
            set2.add(temp);
        }

        int onlyA = set1.size() - set.size();
        int onlyB = set2.size() - set.size();
        int all = set.size();
        System.out.println(onlyA + " " + onlyB + " " + all);
    }
}