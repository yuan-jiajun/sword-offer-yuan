package upup.implementation.classes.treemap;

import org.junit.Test;

import java.util.*;

/**
 * @author Yuan Jiajun
 * @date 2020/9/12 22:15
 * @description @link
 */
public class TreeMapStudy {

    @Test
    public void keyUpSort() {
        // 默认情况，TreeMap按key升序排序
        Map<String, Integer> map = new TreeMap<String, Integer>();
        map.put("acb1", 5);
        map.put("bac1", 3);
        map.put("bca1", 20);
        map.put("cab1", 80);
        map.put("cba1", 1);
        map.put("abc1", 10);
        map.put("abc2", 12);

        // 默认情况下，TreeMap对key进行升序排序
        System.out.println("------------正常情况，TreeMap按key升序排序--------------------");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    @Test
    public void keyDownSort() {
        // TreeMap,按key降序排序
        // 降序排序比较器
        Comparator<String> keyComparator = Comparator.reverseOrder();

        Map<String, Integer> map = new TreeMap<>(keyComparator);
        map.put("acb1", 5);
        map.put("bac1", 3);
        map.put("bca1", 20);
        map.put("cab1", 80);
        map.put("cba1", 1);
        map.put("abc1", 10);
        map.put("abc2", 12);
        System.out.println("------------TreeMap按key降序排序--------------------");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    @Test
    public void valueUpSort() {
        // 默认情况，TreeMap按key升序排序
        Map<String, Integer> map = new TreeMap<String, Integer>();
        map.put("acb1", 5);
        map.put("bac1", 3);
        map.put("bca1", 20);
        map.put("cab1", 80);
        map.put("cba1", 1);
        map.put("abc1", 10);
        map.put("abc2", 12);

        // 升序比较器
        Comparator<Map.Entry<String, Integer>> valueComparator = Comparator.comparingInt(Map.Entry::getValue);

        // map转换成list进行排序
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        // 排序
        list.sort(valueComparator);

        // 默认情况下，TreeMap对key进行升序排序
        System.out.println("------------map按照value升序排序--------------------");
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}