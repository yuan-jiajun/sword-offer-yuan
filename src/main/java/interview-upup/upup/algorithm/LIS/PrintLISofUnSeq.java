package upup.algorithm.LIS;

/**
 * @author Yuan Jiajun
 * @date 2020/9/2 20:43
 * @description
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。（非连续）
 */

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//这里用到了java自带的二分查找法，当然可以自己写，int binarySearch(int []arr,int s, int e, int key )。左闭右开。该方法要求数组非严格单调增。
//该方法自动查找到数组中第一个等于key的值的索引（假设arr中有key），返回该索引；如果没有则会找到第一个大于key的值的索引x。并返回: - x - 1。
//若数组中元素均小于key则返回: - len - 1。也就是可以利用返回值找到一个大于或等于key的值的索引。
//最好自己画图看看，很容易看出来。给一个设计好的测试用例 { 9,10,11,12, 8, 4, 15, -5, -4, -3, 7 }。
public class PrintLISofUnSeq {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        LIS(arr);
    }

    public static int LIS(int[] nums) {
        // 1.minTail[i]用来记录所有长度为i+1的递增序列中，末尾的最小值。可以用反正法证明minTail数组必然是一个单调递增数组。下面关键步骤是通过遍历nums数组逐渐的得到minTail
        // 2.dp[i] 记录以数组nums中第i个数字结尾的LIS的长度。
        // 3.通多上面两个数组求出最小LIS
        int[] minTail = new int[nums.length];//minTail数组真实长度就是LIS长度，不确定，所以创建了一个和nums等长的数组，初始值均为0。
        int[] dp = new int[nums.length];//数组dp长度等于nums长度

        int len = 0;//表示minTail目前用到的长度

        for (int i = 0; i < nums.length; i++) {// 随着数组的遍历不断地跟新minTail
            // 搜索第一个大于nums[l]的数的位置。
            int insert = Arrays.binarySearch(minTail, 0, len, nums[i]);

            while (insert >= 0) {//若查找到minTail中包含nums[l],接着二分查找直到找到第一个大于nums[l]的数
                insert = Arrays.binarySearch(minTail, insert + 1, len, nums[i]);
            }

            insert = -insert - 1;//得到大于nums[l]的第一个值的索引

            // 已有序列都小于num
            if (insert == len) {
                len++;
            }
            // 替换掉第一个大于或等于nums[l]的数,也就是说长为i+1的递增子序列最小值可以是更小的nums[l]。如果数组中没有比num大的数则num添加到末尾。
            minTail[insert] = nums[i];

            dp[i] = insert + 1;
        }

        // 下面代码用来找到按照字母表排序最小的最长递增子序列
        int[] res = new int[len];

        int index = res.length - 1;
        int next = Integer.MAX_VALUE;

        for (int k = nums.length - 1; k >= 0; k--) {
            if (nums[k] <= next && dp[k] == index + 1) {//满足该条件求得的序列就是目标LIS。假设已知LIS最后一个数字（其实就是minTail中最后一个非0值
                //通过该判断求LIS前一个数值？（首先该条件为nums[k]是LIS倒数第二个数值的充分条件，但还需证明由该条件得到的LIS按字典排序最小）。假设除了k满足该条件，
                //还有i，j...满足，那么i，j...不可能在k之后（因为倒着遍历nums），所以推出num[i,j,...]必然大于nums[k]。绝不可能小于或者等于，否则可以推出dp[k]==index+2
                res[index] = nums[k];
                next = res[index];
                index--;
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int val : res)
            sb.append(val).append(" ");
        System.out.println(sb.toString());

        return len;
    }


    @Test
    public void test() {
        System.out.println(LIS(new int[]{4, 5, 6, 2, 3, 7}));
        System.out.println(LIS(new int[]{1, 2, 8, 6, 4}));
    }
}