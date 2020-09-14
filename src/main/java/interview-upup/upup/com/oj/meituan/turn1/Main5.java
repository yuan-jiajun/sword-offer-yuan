package upup.com.oj.meituan.turn1;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Yuan Jiajun
 * @date 2020/9/6 10:23
 * @description
 *类属于lru的最后结果输出
 */
public class Main5 {
    private final int CAPACITY = (int) Math.pow(10.0, 9.0);
    private final LinkedHashMap<Integer, Integer> cache;

    public Main5(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {

            @Override
            protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
                return size() > CAPACITY;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
        Main5 sample = new Main5(2);

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            sample.put(in.nextInt(), 0);
        }

        Stack<Integer> res = new Stack<>();

        res.addAll(sample.cache.keySet());

        while (!res.isEmpty()) {
            System.out.println(res.pop());
        }
    }
}
