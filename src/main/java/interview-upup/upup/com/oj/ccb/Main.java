package upup.com.oj.ccb;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String[] arr1 = str1.split("\\s+");
        String[] arr2 = str2.split("\\s+");

        for (String s : arr1) {
            if (count(str1, s) == 1 && count(str2, s) == 0)
                System.out.println(s);
        }

    }

    public static int count(String string, String regEx) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(string);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}