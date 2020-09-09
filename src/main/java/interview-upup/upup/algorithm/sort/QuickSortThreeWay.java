package upup.algorithm.sort;

/**
 * @author Yuan Jiajun
 * @date 2020/8/18 21:57
 * @description
 */

import org.junit.Test;

/**
 * 4.3 三向切分
 * 对于有大量重复元素的数组，可以将数组切分为三部分，分别对应小于、等于和大于切分元素。
 * 三向切分快速排序对于有大量重复元素的随机数组可以在线性时间内完成排序。
 * <p>
 * <p>
 * a、迭代结束判断，如果迭代到了只剩余1个元素，无需继续进行下面操作，防止死循环；
 * b、跟快速排序一样，使用当前排序部分的第一个元素作为参照物；
 * c、这里与快速排序不一样了。
 * 快速排序中仅记录了“左右指针”；
 * 这里记录了“小于参照物的指针”【lt】、“大于参照物的指针”【gt】，以及“当前指针”【i】
 * d、开始进行“分类”操作
 * i、获取当前值和参照物比较的结果；
 * ii、如果当前的值arr[I]大于参照物，交换当前值的位置【i】和【gt】的位置（先别急，暂时理解为把较大的值，放到数组的后端）；
 * iii、如果当前的值arr[I]小于参照物，交换当前值的位置【i】和【lt】的位置（暂时理解为把较小的值，放到数组的前端）；
 * iv、如果当前的值arr[I]等于参照物，则将当前值的指针【i】的位置后移一位。
 * <p>
 * e、迭代排序位置begin到位置lt - 1的部分；
 * <p>
 * f、迭代排序位置gt + 1到位置end的部分。
 */
public class QuickSortThreeWay<T extends Comparable<T>> extends QuickSortGeneric<T> {
    @Override
    public void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }

        // 记录“少于”、“多余”下标
        int lt = l, gt = h;
        int i = l + 1;

        // 获取参照物
        T v = nums[l];


        //开始计算需要进行迭代的位置
        while (i <= gt) {
            int cmp = nums[i].compareTo(v);
            if (cmp < 0) {          // 当前元素小于参照物
                swap(nums, lt++, i++);
            } else if (cmp > 0) {
                /** 当前元素大于参照物,将当前元素后移，与gt位置的元素与i交换，并且马上进行下一次比较，将原gt位置的元素和参照物比较*/
                swap(nums, i, gt--);
            } else {                // 当前元素等于参照物
                i++;
            }
        }

        //最终迭代比较“小于参照物”的部分和“大于参照物”的部分
        sort(nums, l, lt - 1);
        sort(nums, gt + 1, h);
    }


    @Test
    public void test() {
//        Integer[] data = {9, -16, 30, 23, -30, -49, 25, 21, 30, 293, 108, 161, 783, 376, 265, 330, 598, 646, 812};
        Integer[] data = {10, 10, 9, 9, 12, 12, 8, 8};
        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
        sort((T[]) data, 0, data.length - 1);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
    }


}