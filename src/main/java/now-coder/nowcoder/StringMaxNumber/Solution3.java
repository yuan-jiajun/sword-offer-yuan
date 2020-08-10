package nowcoder.StringMaxNumber;

/**
 * @author yuanjiajun
 * @description https://www.nowcoder.com/practice/ac72e27f34c94856bf62b19f949b8f36?tpId=113&&tqId=33518&rp=1&ru=/ta/job-code-basic&qru=/ta/job-code-basic/question-ranking
 * @date 2020/7/17 0:19
 * <p>
 * 参考 Java排名 第一的代码,但是他的代码存在bug，当测试用例诸如 012345BZ16654656
 * 最后进入 if ((chars[i] >= '0' && chars[i] <= '9'))
 * 不能将 0x16654656 赋成最大值
 *
 * 运行时间：47ms
 * 占用内存：14144k
 */
public class Solution3 {
    public int solve(String s) {
        // write code here

        if (s == null || s.isEmpty()) {
            return 0;
        }

        char[] chars = s.toCharArray();

        int tmp = 0;
        int res = 0;

        int i = 0;
        for (i = 0; i < chars.length; i++) {
            if ((chars[i] >= '0' && chars[i] <= '9')) {
                tmp = tmp * 16 + chars[i] - '0';
            } else if ((chars[i] >= 'A' && chars[i] <= 'F')) {
                tmp = tmp * 16 + chars[i] - 'A' + 10;
            } else {
                //这里一定不能单独只加 else判断，否则可能得不到最大值，得在最后进行一次最大值判定
                res = Math.max(tmp, res);
                tmp = 0;
            }
        }
        res = Math.max(tmp, res);
        return res;
    }

    public static void main(String[] args) {
//        int a = new Solution3().solve("012345BZ16");
        int a = new Solution3().solve("012345BZ16654656");
        System.out.println(a);
    }

}



