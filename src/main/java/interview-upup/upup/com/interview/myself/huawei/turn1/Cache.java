package upup.com.interview.myself.huawei.turn1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuanjiajun
 * @date 2020/9/17 12:18
 * @description @link
 */
public class Cache {
    private static volatile HashMap<Integer, Person> hashMap = new HashMap<>();

    private static volatile Cache cache;

    private Cache() {
    }

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

    public synchronized void update(List<Person> list) {
        for (Person person : list) {
            if (!hashMap.containsKey(person.getId())) {
                hashMap.put(person.getId(), person);
            }
        }
    }

    public synchronized Person queryById(int id) {
        return hashMap.get(id);
    }

    public synchronized List<Person> queryByName(String name) {
        List<Person> list = new ArrayList<>();
        for (Map.Entry<Integer, Person> entry : hashMap.entrySet()) {
            if (entry.getValue().getName().equals(name)) {
                list.add(entry.getValue());
            }
        }
        return list;
    }
}