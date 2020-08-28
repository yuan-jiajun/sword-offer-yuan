package upup.com.oj.alibaba.test3;

/**
 * @author yuanjiajun
 * @description
 * @date 2020/4/24 17:31
 */

import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    //评测题目: 无

// 长度n的数组a，a[x]为有价值的数，当且仅当：x左侧存在大于a[x]的最小数f，右侧存在小于a[x]的最大数g，f是g的倍数。
// 数组里面有多少有价值的数

// 1 <= n <= 10^5
// 3
// 4 3 2
// 1
// https://docs.oracle.com/javase/8/docs/api/java/util/TreeMap.html


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();

        String[] intergers = line.split(" ");
        TreeMap<Integer, Integer> treemap = new TreeMap<Integer, Integer>();
        for (int i = 0; i < size; i++) {
            treemap.put(i, Integer.parseInt(intergers[i]));
        }

        int higher = 0;
        int lower = 0;
        int count = 0;
        for (int i = 1; i < size; i++) {
            higher = treemap.higherKey(i);
            lower = treemap.lowerKey(i);
            if (higher % lower == 0) {
                count++;
            }
        }
        System.out.println(count);
    }


//    public class TreeMapDemo {
//        public static void main(String[] args) {
//
//            // creating tree map
//            TreeMap<Integer, String> treemap = new TreeMap<Integer, String>();
//
//            // populating tree map
//            treemap.put(2, "two");
//            treemap.put(1, "one");
//            treemap.put(3, "three");
//            treemap.put(6, "six");
//            treemap.put(5, "five");
//
//            // getting higher key for key 4
//            System.out.println("Checking values of the map");
//            System.out.println("Value is: "+ treemap.higherKey(3));
//        }
//    }

}