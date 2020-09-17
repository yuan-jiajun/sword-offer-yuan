package upup.com.interview.myself.huawei.test1;

import java.util.HashMap;
import java.util.List;

/**
 * @author yuanjiajun
 * @date 2020/9/17 10:58
 * @description @link
 */
public class Main {
    private static volatile HashMap<Integer, Person> hashMap = new HashMap<>();

    static class Person {
        int id;
        String name;
        int age;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
//
//    static class Node {
//        Person person;
//        Node before;
//        Node after;
//
//        public Node(Person person) {
//            this.person = person;
//        }
//    }
//
//    private int size;
//    private int capacity;
//    private Node sentryHead,sentryTail;


    public synchronized void update(List<Person> list) {
        for (Person person : list) {
            if (hashMap.containsKey(person.getId())) {
            } else {
                hashMap.put(person.getId(), person);
            }
        }
    }

    public synchronized Person queryId(int id) {
        return hashMap.get(id);
    }
}