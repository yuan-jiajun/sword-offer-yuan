package test41_GetMedian;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Yuan Jiajun
 * @date 2020/8/24 16:32
 * @description https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 */

public class GetMedian {

    private static ArrayList<Integer> list = new ArrayList<>();

    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
    }

    public double findMedian() {
        int mid = list.size() / 2;

        if (list.size() % 2 == 0) {
            Double sum = Double.valueOf(list.get(mid)) + Double.valueOf(list.get(mid - 1));
            return sum / 2;
        }
        return Double.valueOf(list.get(mid));
    }

    @Test
    public void test() {
        addNum(-2);
        addNum(3);
        addNum(-4);
        System.out.println(findMedian());
    }


}