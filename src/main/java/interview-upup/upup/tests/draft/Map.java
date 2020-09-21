package upup.tests.draft;

import java.util.HashMap;

/**
 * @author Yuan Jiajun
 * @date 2020/8/28 20:24
 * @description
 */
public class Map {
    public static void main(String[] args) {
//        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        HashMap<Integer, String> map = new HashMap<>();
//        Hashtable<Integer, String> map = new Hashtable<>();
//        HashMap<Integer, String> map = new LinkedHashMap<>();
//        TreeMap<Integer, String> map = new TreeMap<>();

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