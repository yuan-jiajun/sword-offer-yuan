package yuan.test61_IsContinuous;

import java.util.Arrays;

/**
 * @author Yuan Jiajun
 * @date 2020/8/26 15:24
 * @description
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