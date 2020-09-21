package upup.tests.draft;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuan Jiajun
 * @date 2020/9/2 20:50
 * @description
 */

public class demos extends Thread {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        for (String item : list) {
            if (item.equals("3")) {
                System.out.println(item);
                list.remove(item);
            }
        }
        System.out.println(list.size());
    }

}
