package upup.test;

import java.util.HashMap;

/**
 * @author Yuan Jiajun
 * @date 2020/8/28 20:24
 * @description
 */
public class Map {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();

        map.put(1, "yuan");
        map.put(2, "jia");
        map.put(3, "jun");

        map.put(1, "jin");

        map.forEach((key, value) -> System.out.println(value));


    }
}