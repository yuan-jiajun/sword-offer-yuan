package upup.grammar.lambda;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yuan Jiajun
 * @description
 * @date 2020/7/22 21:45
 */
public class LambdaComparator {
    String[] players = {"Rafael Nadal", "Novak Djokovic",
            "Stanislas Wawrinka", "David Ferrer",
            "Roger Federer", "Andy Murray",
            "Tomas Berdych", "Juan Martin Del Potro",
            "Richard Gasquet", "John Isner"};

    @Test
    public void solution1() {
        // 1.1 使用匿名内部类根据 name 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });
        System.out.println(Arrays.toString(players));
    }


    @Test
    public void solution2() {
        // 1.2 使用 lambda expression 排序 players
        Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
//        Comparator<String> sortByName = String::compareTo;

        Arrays.sort(players, sortByName);
        System.out.println(Arrays.toString(players));
    }

    @Test
    public void solution3() {
        // 1.3 也可以采用如下形式:
        Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));
//        Arrays.sort(players, String::compareTo);
        System.out.println(Arrays.toString(players));
    }

    @Test
    public void solution4() {
        System.out.println(Arrays.toString(players));
    }

    @Test
    public void solution5() {
        System.out.println(Arrays.toString(players));
    }
}