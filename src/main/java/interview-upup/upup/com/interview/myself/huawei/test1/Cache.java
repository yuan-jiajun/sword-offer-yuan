package upup.com.interview.myself.huawei.test1;

import java.util.HashMap;
import java.util.List;

/**
 * @author yuanjiajun
 * @date 2020/9/17 12:18
 * @description @link
 */
public class Cache {
    private static volatile HashMap<Integer, Main.Person> hashMap;
    private static volatile Cache cache;

    public static Cache getInstance() {
        if (cache == null) {
            synchronized (Cache.class) {
                if (cache == null) {
                    cache = new Cache();
                }
            }
        }
        return cache;
    }

    public synchronized void update(List<Main.Person> list) {
        for (Main.Person person : list) {
            if (hashMap.containsKey(person.getId())) {
            } else {
                hashMap.put(person.getId(), person);
            }
        }
    }

//    public synchronized Person queryId(int id) {
//        return hashMap.get(id);
//    }
//
//    public synchronized Person queryId(int id) {
//        return hashMap.get(id);
//    }

}