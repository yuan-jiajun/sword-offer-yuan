package nowcoder.NearestNeighbor;

import java.util.Arrays;

/**
 * @author yuanjiajun
 * @description
 * @date 2020/7/22 1:10
 */
public class BinarySortResult {

    /**
     * 结果:
     * <p>
     * 排序前:[8, 1, 2, 5, 4, 9]
     * 排序后:[1, 2, 4, 5, 8, 9]
     * --------------------------------
     * 关键字8的返回值是:4
     * 关键字26的返回值是:-7
     * 关键字6的返回值是:-5
     * 关键字0的返回值是:-1
     * <p>
     * 分析:
     * 当我们查找的关键字是8在该数组中,则返回的结果是该数组排好序之后的下标4;(找到关键字索引从0开始)
     * 接着我们查找关键字26,我们发现这个关键字并不在该数组中,并且26比数组中的所有元素都大,所以返回值是数组 length+1,也就是6+1=7;  (没有找到关键字索引从1开始）
     * 接着我们查找关键字6,由于排好序的数组中第一个大于6的数是8所以返回值就是8所在的索引5;(没有找到关键字索引从1开始）
     * 接着我们查找关键字0,由于在该数组中比0稍大的数是1,则返回1的索引1;(没有找到关键字索引从1开始）
     *
     * 之所以计算插入点值时索引要从1开始算，是因为-0=0，如果从0开始算，那么下面例子中关键字2和关键字4的返回值就一样了。
     *
     * 总结：binarySearch()方法的返回值为：
     * 如果找到了目标，
     * Arrays.binarySearch() 产生的返回值就要大于或等于0。
     *
     * 否则，它产生负返回值，这个负值的计算方式是： -（插入点）-1
     * “插入点”是指，第一个大于查找对象的元素在数组中的位置，如果数组中所有的元素值都小于要查找的对象，“插入点”就等于 Arrays.size()。
     */

    public static void main(String[] args) {
        //定义一个int型的数组
        int[] arr = {8, 1, 2, 5, 4, 9};

        System.out.println("toString:" + Arrays.toString(arr));
        //调用Arrays的排序方法
        Arrays.sort(arr);
        System.out.println("toString:" + Arrays.toString(arr));
        System.out.println("--------------------------------");
        System.out.println("binarySearch 8: " + Arrays.binarySearch(arr, 8));//4
        System.out.println("binarySearch 26: " + Arrays.binarySearch(arr, 26));//-7
        System.out.println("binarySearch 6: " + Arrays.binarySearch(arr, 6));//-5
        System.out.println("binarySearch 7: " + Arrays.binarySearch(arr, 7));//-5
        System.out.println("binarySearch 0: " + Arrays.binarySearch(arr, 0));//-1
    }
}