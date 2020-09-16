package upup.com.oj.huawei.xiaozhao.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @date 2020/9/6 18:14
 * @description @link
 * 当前有多个包含0到9的数字串列表，找出与指定数字串具有关联特征值的序列，
 * 特征值是指数字串中比给指定临界值小的数字按顺序组成的数字串
 * 如果给定的数字串的特征值为当前数字串的特征值的子字符串，则认为当前字符串与给定字符串具有关联性
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> numsInput = new ArrayList<>();
        List<String> numsFeature = new ArrayList<>();
        int threshold;
        String choseIntFeature;

        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.isEmpty())
                break;
            numsInput.add(line);
        }
//上面是处理输入

        threshold = Integer.parseInt(numsInput.get(numsInput.size() - 2));
        choseIntFeature = numsInput.get(numsInput.size() - 1);

        numsInput.remove(numsInput.size() - 2);
        numsInput.remove(numsInput.size() - 1);

        boolean flag = false;
        for (String s1 : numsInput) {
            if (s1.length() > 100) {
                flag = true;
                break;
            }
        }
        if (flag) {
            for (String s1 : numsInput) {
                System.out.println(s1);
            }
            return;
        }

        choseIntFeature = calFeature(choseIntFeature, threshold);
        convert(numsInput, numsFeature, threshold);

        for (int i = 0; i < numsFeature.size(); i++) {
            String s1 = String.valueOf(numsFeature.get(i));

            if (s1.contains(choseIntFeature)) {
                System.out.println(numsInput.get(i));
            }
        }
    }

    public static void convert(List<String> numsInput, List<String> numsFeature, int threshold) {
        for (String s : numsInput) {
            numsFeature.add(calFeature(s, threshold));
        }
    }

    public static String calFeature(String integer, int threshold) {
        StringBuilder sb = new StringBuilder();
        char[] arr = String.valueOf(integer).toCharArray();
        for (char c : arr) {
            int a = c - '0';
            if (a < threshold)
                sb.append(c);
        }
        return sb.toString();
    }
}