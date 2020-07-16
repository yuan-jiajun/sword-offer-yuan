package StringMaxNumber;

import org.testng.annotations.Test;

import java.util.*;

/**
 * @author yuanjiajun
 * @description https://www.nowcoder.com/practice/ac72e27f34c94856bf62b19f949b8f36?tpId=113&&tqId=33518&rp=1&ru=/ta/job-code-basic&qru=/ta/job-code-basic/question-ranking
 * @date 2020/7/17 0:19
 * 链接：https://www.nowcoder.com/questionTerminal/ac72e27f34c94856bf62b19f949b8f36?f=discussion
 * 来源：牛客网
 *
 * 从第一位开始遍历，如果是非法字符，跳过，否则从该字符起一直追加到遇到非法字符为止，并计算该段字符对应的10进制数，
 * 计算后与当前最大值比较取其大者，之后直接将索引位向后加该段合法字符串的长度-1再继续循环
 *
 * 运行时间：51ms
 * 占用内存：14744k
 */
public class Solution {
    public int solve(String s) {
        // write code here
        byte[] bytes = s.getBytes();
        int tmp = 0;
        int res = 0;
        int count = 0;

        byte[] temp = new byte[bytes.length - 1];
        int i, j = 0;
        for (i = 0; i < bytes.length; i++) {
            if ((bytes[i] >= '0' && bytes[i] <= '9') || (bytes[i] >= 'A' && bytes[i] <= 'F')) {
                temp[0] = bytes[i];
                count++;
                i++;
                for (j = 1; i < bytes.length; j++, i++) {
                    if ((bytes[i] >= '0' && bytes[i] <= '9') || (bytes[i] >= 'A' && bytes[i] <= 'F')) {
                        temp[j] = bytes[i];
                        count++;
                    } else {
                        break;
                    }
                }

                tmp = bytesToInt(temp, count);
                res = Math.max(tmp, res);
                count = 0;
            }
        }
        return res;
    }

    public int bytesToInt(byte[] bytes, int count) {
        int result = 0;
        int bitValue;
        for (int i = 0; i < count; i++) {
            if ((bytes[i] >= '0' && bytes[i] <= '9')) {
                bitValue = bytes[i] - '0';
                result += (int) Math.pow(16, count - i - 1) * bitValue;
                continue;
            }
            if ((bytes[i] >= 'A' && bytes[i] <= 'F')) {
                bitValue = bytes[i] - 'A' + 10;
                result += (int) Math.pow(16, count - i - 1) * bitValue;
            }

        }
        return result;
    }

    @Test
    public void test() {
        int a = new Solution().solve("012345BZ16");
        System.out.println(a);
    }

}



