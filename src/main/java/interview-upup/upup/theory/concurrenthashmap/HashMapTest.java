package upup.theory.concurrenthashmap;

/**
 * @author Yuan Jiajun
 * @date 2020/9/13 17:08
 * @description @link
 */

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
//        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            TestThread testThread = new TestThread(map, "线程名字：" + i);
            testThread.start();
        }
    }
}

class TestThread extends Thread {
    public Map<String, String> map;
    public String name;

    public TestThread(Map<String, String> map, String name) {
        this.map = map;
        this.name = name;
    }
    public void run() {
        int i = 5;
        map.put("键" + i, "值" + i);
        map.remove("键" + i);
        System.out.println(name + "   size = " + map.size());
    }
}

