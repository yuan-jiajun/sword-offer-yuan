package upup.jdktheory.iteratordelete;

import java.util.ArrayList;

/**
 * @author Yuan Jiajun
 * @date 2020/9/21 16:43
 * @description @link
 */
public class IteratorDelete {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("d");

//        //1,普通for循环删除,索引要--
//        for (int i = 0; i < list.size(); i++) {
//            if ("b".equals(list.get(i))) {
//                list.remove(i--);  //如果不--，就会漏删
//            }
//        }
//
//        //2,迭代器删除
//        Iterator<String> it = list.iterator();
//        while (it.hasNext()) {
//            if ("b".equals(it.next())) {
//                //list.remove("b");	//不能用集合的删除方法,因为迭代过程中如果集合修改会出现并发修改异常
//                it.remove();     //操作自身的东西就可以
//            }
//        }
//
//        //迭代器的另一种写法
//        for (Iterator<String> it2 = list.iterator(); it2.hasNext(); ) {
//            if ("b".equals(it2.next())) {
//                //list.remove("b");	//不能用集合的删除方法,因为迭代过程中如果集合修改会出现并发修改异常
//                it2.remove();
//            }
//        }

        //3,增强for循环,增强for循环不能删除,只能遍历，因为它的底层用的是迭代器，迭代器就不能删除这里也就不能删除
        for (String string : list) {
            if ("b".equals(string)) {
                list.remove("b");
            }
        }

        System.out.println(list);
    }
}