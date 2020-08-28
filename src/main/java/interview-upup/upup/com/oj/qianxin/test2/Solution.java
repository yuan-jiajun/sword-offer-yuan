package upup.com.oj.qianxin.test2;

import java.util.ArrayList;

/**
 * @author Yuan Jiajun
 * @description
 * @date 2020/8/1 16:25
 */
public class Solution {
    public static ArrayList<String> getNums(ArrayList<Integer> list) {
        ArrayList<String> nums = new ArrayList<>();
        if (list.size() == 2) {
            nums.add("" + list.get(0) + list.get(1));
            nums.add("" + list.get(1) + list.get(0));
            return nums;
        } else {
            for (int i = 0; i < list.size(); i++) {
                Integer remove = list.remove(i);
                ArrayList<String> nums1 = getNums(list);

                for (String s : nums1) {
                    nums.add(remove + s);
                }
                list.add(i, remove);
            }
            return nums;
        }

    }

    public static int parseInt(String string) {
        int res = 0;
        int base = 1;
        for (int i = string.length() - 1; i >= 0; i--) {
            res += (string.charAt(i) - '0') * base;
            base = base * 10;
        }
        return res;
    }

    public static int reletive_7(int[] digit) {
        // write code here
        if (digit == null || digit.length == 0) {
            return 0;
        }
        if (digit.length == 1) {
            return digit[0] % 7 == 0 ? 1 : 0;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : digit) {
            arrayList.add(i);
        }
        int res = 0;
        ArrayList<String> nums = getNums(arrayList);
        for (String num : nums) {
            if (parseInt(num) % 7 == 0) {
                res++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reletive_7(new int[]{1,2,3,4,5,6,7}));
    }
}