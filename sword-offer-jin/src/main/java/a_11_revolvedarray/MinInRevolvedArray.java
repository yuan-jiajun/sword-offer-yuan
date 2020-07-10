package a_11_revolvedarray;

public class MinInRevolvedArray {
    /**
     * 旋转数组中的最小值， {3，4，5，1，2} 为 {1，2，3，4，5}的一个旋转数组
     * 采用二分法，特例：
     * 交换0个，如{1，2，3，4，5}
     * {0，1，1，1，1}的旋转{1，0，1，1，1}，会导致几个指针指向的值相等，此时只能顺序查找
     *
     * @return
     */
    public static int findMinOfRevolvedArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("invalid input");
        }

        int left = 0;
        int right = nums.length - 1;

        if (nums[left] < nums[right])
            return nums[left];

        int midIndex = 0;
        //二分法 循环实现
        while (right - left > 1) {
            midIndex = (right + left) >> 1;
            if (nums[left] == nums[right] && nums[left] == nums[midIndex]) {//三个数相等，无法判断在哪边，只能顺序查找
                int minIndex = 0;
                for (int i = 0; i < nums.length - 2; i++) {
                    if (nums[i] > nums[i + 1]) {
                        minIndex = i + 1;
                        break;
                    }
                }
                return nums[minIndex];
            }
            //不是三个数相等的情况
            if (nums[midIndex] >= nums[right]) {
                left = midIndex;
            } else {
                right = midIndex;
            }
        }

        return nums[right]; //递归之后一定是left+1=right, 且left处为大值，right处为小值
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 4, 5, 1, 2};
        int[] nums2 = new int[]{1, 2, 3, 4, 5};
        int[] nums3 = new int[]{1, 0, 1, 1, 1};
        int[] nums4 = new int[]{1, 1, 1, 0, 1};
        int[] nums5 = new int[]{2, 2, 2, 1, 2};

        System.out.println(findMinOfRevolvedArray(nums1));
        System.out.println(findMinOfRevolvedArray(nums2));
        System.out.println(findMinOfRevolvedArray(nums3));
        System.out.println(findMinOfRevolvedArray(nums4));
        System.out.println(findMinOfRevolvedArray(nums5));
    }


}
