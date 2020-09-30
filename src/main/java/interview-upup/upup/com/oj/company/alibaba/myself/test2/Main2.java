package upup.com.oj.company.alibaba.myself.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author yuanjiajun
 * @description
 * @date 2020/3/30 20:48
 */
public class Main2 {
    private static double getMean(List<int[]> serials) {
        return serials.stream().map(ints -> Arrays.stream(ints).max().getAsInt()).mapToInt(Integer::intValue).average().getAsDouble();
    }

    private static List<int[]> getSubSerials(int[] serial) {
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i <= serial.length; i++) {
            for (int j = 0; j <= serial.length - i; j++) {
//                System.out.println("i = " + i + " j = " + j + " " + Arrays.toString(Arrays.copyOfRange(serial, j, j + i)));
                res.add(Arrays.copyOfRange(serial, j, j + i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //空格切分
        try {

            int n = Integer.parseInt(scanner.nextLine());
            String line = scanner.nextLine();

            int[] ints = new int[n];
            String[] integers = line.split(" ");
            for (int i = 0; i < n; i++) {
                ints[i] = Integer.parseInt(integers[i]);
            }

            System.out.println(getMean(getSubSerials(ints)));


        } catch (
                Exception e) {

        }
    }


/*    public static void main(String[] args) {
        int[] a = new int[]{2,5};
        int[] b = new int[]{2,3,15};
        int[] c = new int[]{2,3,10};
        List<int[]> res = new ArrayList<>();

        res.add(a);
        res.add(b);
        res.add(c);

        System.out.println(getMean(res));
    }*/


}