package upup.demos;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Yuan Jiajun
 * @date 2020/8/28 20:24
 * @description
 */
public class Map {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();
//        HashMap<Integer, String> map = new HashMap<Integer, String>();
//        HashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
//        TreeMap<Integer, String> map = new TreeMap<Integer, String>();

//        map.put(null, "null");
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        map.put(5, "5");
//        map.put(null, "5");

        map.forEach((key, value) -> System.out.println(key + "--->" + value));

//        HashSet<String> set = new HashSet();
//        set.add("yuan");
//        set.add("yuan");
//        set.add(null);
//        set.add(null);
//
//        set.forEach(System.out::println);
    }
}