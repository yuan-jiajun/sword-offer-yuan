package yuan.test43_NumberOf1Between1ToN;

/**
 * @author yuanjiajun
 * @date 2020/8/28 1:02
 * @description https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 */
public class NumberOf1Between1ToN {

    /*参考https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/*/
    //这种题有种找规律的感觉
    public int numberOf1Between1ToN(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;

        while (high != 0 || cur != 0) {//当 high 和 cur 同时为 0 时，说明已经越过最高位，因此跳出
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }

            low += cur * digit;//将 cur 加入 low ，组成下轮 low
            cur = high % 10;// 下轮 cur 是本轮 high 的最低位
            high /= 10;// 将本轮 high 最低位删除，得到下轮 high
            digit *= 10;//位因子每轮 × 10

        }
        return res;
    }
}