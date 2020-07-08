package arrayfind_3;

import java.util.HashMap;
import java.util.Map;

public class ArrayFind {
    /**
     * 查找数组中重复的数字，结果保存在result中，找到返回true，没有找到或者非法输入报异常
     *
     * @param numbers
     * @param length
     * @return
     */
    public static int findRepeat(int[] numbers, int length) {
        //非法输入
        if (numbers == null || numbers.length != length) {
            throw new RuntimeException("Invalid input");
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>((length / 3 + 1) * 4); //为了避免map扩容，给定初始容量
        for (int number : numbers) {
            if (map.containsKey(number)) {
                return number;
            } else {
                map.put(number, 1);
            }
        }
        throw new RuntimeException("Invalid input");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,0,2,5,3};
        System.out.println(findRepeat(nums, nums.length));

    }
}
