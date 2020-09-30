package upup.com.oj.company.alibaba.jhj.test2;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @date 2020/9/29 19:06
 * @description @link
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        in.nextLine();
        List<String> diction = new ArrayList<>();
        List<String> input = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        while (n > 0) {
            diction.add(in.nextLine());
            n--;
        }
        while (q > 0) {
            input.add(in.nextLine());
            q--;
        }

        StringBuilder sb = new StringBuilder();
        for (String s : input) {
            int resTemp = 0;
            int count = 0;
            int min = s.length();

            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));

                for (String s1 : diction) {
                    if (s1.startsWith(sb.toString())) {
                        count++;
                    }
                }

                resTemp = i + 1;

                for (String s1 : diction) {
                    if (s1.startsWith(sb.toString())) {
                        if (s1.contains(sb.toString()) && s.length() - i > count) {
                            resTemp = resTemp + count;
                            resTemp = resTemp + (s.length() - s1.length());
                            if (resTemp < min)
                                min = resTemp;
                        }
                    }
                }
            }
            sb.setLength(0);
            res.add(min);
        }

        for (Integer re : res) {
            System.out.println(re);
        }
    }
}