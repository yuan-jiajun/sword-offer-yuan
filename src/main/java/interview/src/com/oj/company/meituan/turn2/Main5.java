package com.oj.company.meituan.turn2;

import java.util.*;

/**
 * @author Yuan Jiajun
 * @date 2020/9/13 11:38
 * @description @link
 */
public class Main5 {
    static class Inner implements Comparable<Inner> {
        int a;
        int b;
        int c;


//        @Override
//        public int compare(Inner o1, Inner o2) {
//            if (o1.b > o2.b) {
//                return 1;
//            } else if (o1.b == o2.b && o1.a > o2.a) {
//                return 1;
//            } else if (o1.b == o2.b && o1.a == o2.a) {
//                return 0;
//            }
//            return -1;
//        }


        @Override
        public int compareTo(Inner o) {
            if (this.b > o.b) {
                return -1;
            } else if (this.b == o.b && this.a > o.a) {
                return -1;
            } else if (this.b == o.b && this.a == o.a) {
                return 0;
            }
            return 1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        List<Inner> list = new ArrayList<>();
        int count = 1;
        while (num > 0) {
            Inner inner = new Inner();
            inner.a = in.nextInt();
            inner.b = in.nextInt();
            list.add(inner);
            inner.c = count++;
            num--;
        }

        Collections.sort(list);
        list.forEach(v -> System.out.println(v.c));
    }
}