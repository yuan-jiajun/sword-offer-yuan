package upup.impclass;


import java.util.LinkedHashMap;

/**
 * @author Yuan Jiajun
 * @description https://blog.csdn.net/qq_37142346/article/details/94964941
 * @date 2020/7/22 15:51
 * <p>
 * 在java的集合类中有LinkedHashMap类，
 * 当参数accessOrder为true的时候，就会按照访问顺序排序，最后访问的放在最前面，最早访问的放在后面，
 * 这样我们就可以实现LRU算法了。这种方式比较简单，代码如下：
 */
public class LinkedHashMapLRUCache {
    private final int CAPACITY = 2;
    private final LinkedHashMap<Integer, Integer> cache;

    public LinkedHashMapLRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {

            @Override
            protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
                return size() > CAPACITY;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
//        return cache.get(key);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LinkedHashMapLRUCache sample = new LinkedHashMapLRUCache(2);

        sample.put(1, 1);
        sample.put(2, 2);
        sample.put(3, 3);
        sample.put(4, 4);
        sample.put(5, 5);
        sample.put(6, 6);
    }
}
