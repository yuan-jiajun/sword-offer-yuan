package upup.com.oj.qianxin.test1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @description
 * @date 2020/8/1 15:00
 */
public class Solution {

    static class Thing {
        int price;
        int value;
        double usedRate;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalMoney = Integer.parseInt(in.nextLine());
        int totalKinds = Integer.parseInt(in.nextLine());


        HashMap moneyValueMap = new HashMap<Integer, Thing>();

        int money, value;
        double usedRate;
        for (int i = 0; i < totalKinds; i++) {
            Thing thing = new Thing();
            thing.price = in.nextInt();
            thing.value = in.nextInt();
            thing.usedRate = thing.value + 1.0 / thing.price;

            moneyValueMap.put(i, thing);
        }


        double useRate[] = new double[totalKinds];
        for (int i = 0; i < totalKinds; i++) {
            Thing thing = (Thing) moneyValueMap.get(i);
            useRate[i] = thing.usedRate;
        }
        Arrays.sort(useRate);

        HashMap moneyValueMap2 = new HashMap<Integer, Thing>();
        int rank = 0;
        for (int i = totalKinds - 1; i >= 0; i--) {
            double useRateTmp = useRate[i];
            for (int j = 0; j < totalKinds; j++) {
                Thing thing = (Thing) moneyValueMap.get(j);
                if (thing.usedRate == useRateTmp)
                    moneyValueMap2.put(rank++, thing);
            }
        }

        int remainMoney = 0;
        int maxValue = 0;
        int maxValueTmp = 0;


        for (int i = 0; i < totalKinds; i++) {
            remainMoney = totalMoney;
            maxValueTmp = maxValueCount(moneyValueMap2, remainMoney, i, 0);
            if (maxValueTmp > maxValue)
                maxValue = maxValueTmp;

        }

        System.out.println(maxValue);

    }

    static int maxValueCount(HashMap moneyValueMap2, int remainMoney, int k, int maxValue) {
        if (k > moneyValueMap2.size() - 1)
            return maxValue;
        Thing thing = (Thing) moneyValueMap2.get(k);
        int count = (remainMoney / thing.price);
        maxValue += count * thing.value;
        remainMoney = remainMoney - count * thing.price;
        int max = 0;
        for (int i = 1; i < moneyValueMap2.size(); i++) {
            int tmp = maxValueCount(moneyValueMap2, remainMoney, k + i, maxValue);
            if (tmp > max)
                max = tmp;
        }
        return max;
    }

}