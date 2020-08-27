package yuan.test13_MovingCount;

/**
 * @author Yuan Jiajun
 * @date 2020/8/27 16:52
 * @description 机器人的运动范围，一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。求机器人能够达到多少个格子
 */
public class MovingCount {
    /**
     * 机器人能到达的格子数
     */
    public static int movingCount(int rows, int cols, int k) {
        int[][] flag = new int[rows][cols]; // 记录是否已经走过
        return helper(0, 0, rows, cols, flag, k);
    }

    /**
     * 递归查找
     */
    private static int helper(int i, int j, int rows, int cols, int[][] flag, int k) {
        if (i < 0 || i >= rows || j < 0 || j >= cols ||
                numSum(i) + numSum(j) > k || flag[i][j] == 1) {
            return 0;
        }

        flag[i][j] = 1;//如果满足上面的条件，将访问标志位置为1，return加1 ，递归调用旁边的格子

        return 1 +
                helper(i - 1, j, rows, cols, flag, k) +
                helper(i + 1, j, rows, cols, flag, k) +
                helper(i, j - 1, rows, cols, flag, k) +
                helper(i, j + 1, rows, cols, flag, k);
    }

    /**
     * 求输入数的每一位之和
     */
    private static int numSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }

}