package nowcoder.StringMaxNumber;

/**
 * @author yuanjiajun
 * @description https://www.nowcoder.com/practice/ac72e27f34c94856bf62b19f949b8f36?tpId=113&&tqId=33518&rp=1&ru=/ta/job-code-basic&qru=/ta/job-code-basic/question-ranking
 * @date 2020/7/17 0:19
 *
 *从左到右遍历，若为0-9 A-F，cur = cur*16+当前元素值；若不是，cur置0，每次比较cur和存储的最大结果res。
 *
 * 运行时间：44ms
 * 占用内存：14592k
 */
public class Solution2 {
    public int solve(String s) {
        // write code here
        byte[] bytes = s.getBytes();
        int tmp = 0;
        int res = 0;
        int count = 0;

        int i, j, bitValue = 0;
        for (i = 0; i < bytes.length; ) {
            if ((bytes[i] >= '0' && bytes[i] <= '9')) {
                bitValue = bytes[i] - '0';
                tmp = tmp * 16 + bitValue;
            } else if ((bytes[i] >= 'A' && bytes[i] <= 'F')) {
                bitValue = bytes[i] - 'A' + 10;
                tmp = tmp * 16 + bitValue;
            } else i++;

            while (i < bytes.length) {
                if ((bytes[i] >= '0' && bytes[i] <= '9')) {
                    bitValue = bytes[i] - '0';
                    tmp = tmp * 16 + bitValue;
                    i++;
                    continue;
                }
                if ((bytes[i] >= 'A' && bytes[i] <= 'F')) {
                    bitValue = bytes[i] - 'A' + 10;
                    tmp = tmp * 16 + bitValue;
                    i++;
                    continue;
                }
                break;

            }

            res = Math.max(tmp, res);
            tmp = 0;

        }
        return res;
    }


    //    @Test
//    public void test() {
    public static void main(String[] args) {
//        int a = new Solution2().solve("012345BZ16");
        int a = new Solution2().solve("012345BZ16654656");
        System.out.println(a);
    }
}



