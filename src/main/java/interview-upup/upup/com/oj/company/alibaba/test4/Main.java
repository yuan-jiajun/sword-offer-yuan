package upup.com.oj.company.alibaba.test4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author yuanjiajun
 * @description
 * @date 2020/3/31 16:44
 */
public class Main {
    public static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public static void add(int ts, int lantency) {
        map.put(ts, lantency);
    }

    public static void queey(int start_ts, int end_ts) {
        int cout = 0;
        int totalLantency = 0;

        for (int ts : map.keySet()) {
            if (ts >= start_ts && ts <= end_ts) {
                cout++;
                totalLantency += map.get(ts);
            }
        }
        try {
            System.out.println(totalLantency / cout);
        } catch (Exception e) {

        }
    }

    public static void dealCommand(String command) {
        String[] cmSplits = command.split("\\s+");
        String cmTyte = null;
        String parameter1 = null;
        String parameter2 = null;
        try {
            cmTyte = cmSplits[0];
            parameter1 = cmSplits[1];
            parameter2 = cmSplits[2];
        } catch (Exception e) {

        }

        switch (cmTyte) {
            case "add":
                add(Integer.parseInt(parameter1), Integer.parseInt(parameter2));
                break;
            case "query":
                queey(Integer.parseInt(parameter1), Integer.parseInt(parameter2));
                break;
            default:
                System.out.println("输入命令不合法: " + command);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lineCount = Integer.parseInt(scanner.nextLine());

        String[] commands = new String[lineCount];
        for (int i = 0; i < lineCount; i++) {
            commands[i] = scanner.nextLine();
        }

        for (int i = 0; i < lineCount; i++) {
            dealCommand(commands[i]);
        }

    }

//    public static void main(String[] args) throws Exception {
//        InputStream is = new FileInputStream("F:\\jobtests\\alibaba\\附件\\latency\\input\\input200000.txt");
//        String line; // 用来保存每行读取的内容
//        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//        line = reader.readLine(); // 读取第一行
//
//        int lineCount = Integer.parseInt(line);
//        String[] commands = new String[lineCount];
//        for (int i = 0; i < lineCount; i++) {
//            commands[i] = reader.readLine();
//        }
//
//        for (int i = 0; i < lineCount; i++) {
//            dealCommand(commands[i]);
//        }
//
//    }

}