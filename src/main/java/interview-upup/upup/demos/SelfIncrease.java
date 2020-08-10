package upup.demos;

/**
 * @author Yuan Jiajun
 * @description
 * @date 2020/7/1 12:06
 */
public class SelfIncrease {
    public static void main(String[] args) {
        int i = 1;
        i = i++;
        i++;
        i++;
        i++;
        i = i++;

//        i = ++i;
//        i = i+1;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("");
    }

}