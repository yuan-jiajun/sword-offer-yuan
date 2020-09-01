package yuan.test21_OddEvenNumber;

/**
 * @author Yuan Jiajun
 * @date 2020/9/1 9:49
 * @description
 */
public class OddEvenNumber {
    /**
     * 解法一：移动偶数位置
     * 时间复杂度 O（n²)，空间复杂度 O（1)
     */
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            int j = i - 1;

            if (array[i] % 2 != 0) {//如果array[i]是奇数
                while (j >= 0) {

                    if (array[j] % 2 != 0) {//奇数
                        break;
                    }

                    if (array[j] % 2 == 0) {//偶数
                        int t = array[j + 1];
                        array[j + 1] = array[j];
                        array[j] = t;
                        j--;
                    }
                }
            }
        }
    }

    /**
     * 解法二：双指针法
     * 时间复杂度 O（n)，空间复杂度 O（1)
     */
    public int[] reOrderArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            /**从前往后找，直到找到个偶数*/
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }
            /**从后往前找，直到找到个奇数数*/
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }

            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }


        }
        return nums;
    }
}