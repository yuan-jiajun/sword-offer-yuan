package upup.inputoutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerInfiniteInput {

    /**
     * 测试无限输入，可以有无限多行，来自字节笔试题
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> results = new ArrayList<>();
        String line;

        while (!(line = in.nextLine()).isEmpty()) {
            int index = line.indexOf(' ');
            results.add(doSomething(line.substring(0, index), line.substring(index + 1)));
        }

        System.out.println(results);
    }

    private static String doSomething(String string1, String string2) {
        return string1 + string2;
    }
}
