package upup.com.oj.company.meituan.turn2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main4_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = Integer.parseInt(sc.nextLine());
            String string = sc.nextLine();
            if (string.length() >= 2) {
                char[] arr = string.toCharArray();
                ArrayList<String> ls = new ArrayList<>();
                ls.add(string);

                if (arr[0] > 'A') {
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


                System.out.println(ls.size());
                System.out.println();


            } else {
                System.out.println(1);
            }
        }
    }

    public static void clockwise(char[] arr, int locate, ArrayList<String> ls, int botton) {
        char locateLetterBefore = arr[locate - 1];
        char locateLetter = arr[locate];
        char locateLetterAfter = arr[locate + 1];

        if (locateLetter == 'Z') {
        } else if (locateLetterBefore == 'A' && botton == 1) {
        } else if (locateLetterAfter == 'A' && botton == 2) {
        } else if (botton == 1) {
            locateLetter += 1;
            locateLetterBefore -= 1;
        } else if (botton == 2) {
            locateLetter += 1;
            locateLetterAfter -= 1;
        }
    }
}

