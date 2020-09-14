package yuan.test61_IsContinuous;

import java.util.Arrays;

/**
 * @author Yuan Jiajun
 * @date 2020/8/26 15:24
 * @description @link https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 */
public class IsContinuous {
    public static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        int count = 0;
        int diff = 0;
        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                count++;
                continue;
            }

            if (numbers[i] == numbers[i + 1]) {
                return false;
            }

            diff += numbers[i + 1] - numbers[i] - 1;
        }

        return diff <= count;
    }
}