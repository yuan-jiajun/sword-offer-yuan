package upup.com.oj.huawei.xiaozhao.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @date 2020/9/6 18:14
 * @description
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

        convert(numsInput, numsFeature, threshold);
        choseIntFeature = calFeature(choseIntFeature, threshold);

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