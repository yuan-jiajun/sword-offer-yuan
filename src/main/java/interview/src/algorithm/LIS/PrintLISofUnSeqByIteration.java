package algorithm.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Yuan Jiajun
 * @date 2020/9/4 17:01
 * @description
 */
public class PrintLISofUnSeqByIteration {
    public static void LIS(int[] nums) {
        List<List<Integer>> res = new CopyOnWriteArrayList<>();

        List<Integer> tmep = new ArrayList<>();
        res.add(tmep);
        tmep.add(nums[0]);

        findLIS(nums, 1, res);

        List<Integer> result = res.get(0);

        for (List<Integer> re : res) {
            if (re.size() > result.size())
                result = re;
        }

        System.out.println(Arrays.toString(result.toArray()));
    }

    public static void findLIS(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length)
            return;
        List<Integer> addChose = null;
        int maxSize = 0;
        for (List<Integer> temp : res) {
            if (nums[index] > temp.get(temp.size() - 1) && temp.size() > maxSize) {
                addChose = temp;
                maxSize = addChose.size();
            }
        }
        if (addChose != null) {
            addChose.add(nums[index]);
        } else {
            List<Integer> tmep = new ArrayList<Integer>();
            res.add(tmep);
            tmep.add(nums[index]);
        }
        findLIS(nums, index + 1, res);
    }

    public static void main(String[] args) {
        LIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        LIS(new int[]{4, 5, 6, 2, 3, 7});
        LIS(new int[]{1, 2, 8, 6, 4});
        LIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});
    }
}