package com.oj.company.meituan.turn2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main4_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = Integer.parseInt(sc.nextLine());
            String string = sc.nextLine();
            if(string.length() >= 2) {
                char[] arr = string.toCharArray();
                ArrayList<String> ls = new ArrayList<>();
                ls.add(string);
                if (arr[1] > 'A') {
                    arr[0] += 1;
                    arr[1] -= 1;
                    ls.add(String.valueOf(arr));
                    arr[0] -= 1;
                    arr[1] += 1;
                }
                if (arr[num - 2] > 'A') {
                    arr[num - 1] += 1;
                    arr[num - 2] -= 1;
                    ls.add(String.valueOf(arr));
                    arr[num - 1] -= 1;
                    arr[num - 2] += 1;
                }
                for (int i = 1; i < num - 1; i++) {
                    if (arr[i + 1] > 'A') {
                        arr[i] += 1;
                        arr[i + 1] -= 1;
                        ls.add(String.valueOf(arr));
                        arr[i] -= 1;
                        arr[i + 1] += 1;
                    }
                    if (arr[i - 1] > 'A') {
                        arr[i] += 1;
                        arr[i - 1] -= 1;
                        ls.add(String.valueOf(arr));
                        arr[i] -= 1;
                        arr[i - 1] += 1;
                    }
                }

                System.out.println(ls.size());
                System.out.println();


            }else{
                System.out.println(1);
            }
        }
    }
}
