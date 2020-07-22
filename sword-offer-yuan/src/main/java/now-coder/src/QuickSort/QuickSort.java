package QuickSort;

import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @description https://www.nowcoder.com/questionTerminal/3385982ae71d4a1ca8bf3d03614c0325?f=discussion
 * @date 2020/7/17 11:43
 * <p>
 * 谁出的憨憨题目，自己给的输入错误的测试用例通不过
 */
public class QuickSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputString = scan.nextLine();
        String[] stringArray = inputString.split(" ");
        int inputCount = Integer.parseInt(stringArray[0]);

        int realCount = stringArray.length - 1;
        int[] data = new int[realCount];
        if (realCount != inputCount) {
            System.out.println("输入的个数不合理");
        }

        for (int i = 0; i < realCount; i++) {
            data[i] = Integer.parseInt(stringArray[i + 1]);
        }
        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
        quickSort(data, 0, data.length - 1);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
    }


    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    //left 和 right 都是数组的下标
    private static int getIndex(int[] data, int left, int right) {
        //如果left等于right，即数组只有一个元素，直接返回

        int pivot = data[left];
        int i = left;//是否加1 都可以
//        int i = left + 1;
        int j = right;

        while (true) {
            while (data[i] <= pivot && i < right) i++;
            while (data[j] >= pivot && j > left) j--;
            if (i < j) {
                swap(data, i, j);
            } else break;
        }
        swap(data, left, j);

        return j;
    }


    public static void quickSort(int[] data, int left, int right) {
        if (left < right) {
            int index = getIndex(data, left, right);
            quickSort(data, left, index - 1);//递归调用
            quickSort(data, index + 1, right);
        }
    }
}