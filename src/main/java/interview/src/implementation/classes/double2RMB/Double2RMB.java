package implementation.classes.double2RMB;

/**
 * @author yuanjiajun
 * @date 2020/9/11 0:10
 * @description @link
 */


public class Double2RMB {
    static final String[] CHARACTER = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    static final String[] UNIT = {"拾", "佰", "仟"};

    public static String[] divideByPoint(double input) {
        long integer = (long) input;
        long decimal = Math.round((input - integer) * 100);
        return new String[]{integer + "", String.valueOf(decimal)};
    }

    public static String parseInteger(String integer) {
        boolean flag = true;
        String result = "";
        int index = 0;
        //判断第一位是不是0；
        while (integer.charAt(index) == '0') {
            index++;
        }
        int numLength = integer.length();

        for (int i = index; i < integer.length() - 1; i++) {
            int num = integer.charAt(i) - 48;
            int remain = numLength - i - 1;
            int tempUnit = remain % 4;
            if (num != 0) {
                flag = false;
                if (tempUnit != 0) {
                    result += CHARACTER[num] + UNIT[tempUnit - 1];
                } else {
                    result += CHARACTER[num];
                    if (remain / 4 == 2) {
                        result += "亿";
                    } else if (remain / 4 == 1) {
                        result += "万";
                    }
                }
            } else if (tempUnit != 0) {
                if (flag == false) {
                    result += "零";
                }
            } else {
                if (remain / 4 == 2) {
                    result += "亿";
                } else if (remain / 4 == 1) {
                    result += "万";
                }
            }

        }
        int last = integer.charAt(numLength - 1) - 48;
        return result + CHARACTER[last];
    }

    public static String parseDecimal(String decimal) {
        if (decimal.length() == 0) {
            return "";
        }
        if (decimal.length() == 1) {
            decimal += 0;
        }

        int first = decimal.charAt(0) - 48;
        int second = decimal.charAt(1) - 48;
        if (first != 0 && second != 0) {
            return CHARACTER[first] + "角" + CHARACTER[second] + "分";
        } else if (first != 0) {
            return CHARACTER[first] + "角";
        } else if (second != 0) {
            return CHARACTER[second] + "分";
        } else {
            return "";
        }
    }

    public static String parse(double input) {
        String[] parts = divideByPoint(input);
        String integer = parseInteger(parts[0]);
        String decimal = parseDecimal(parts[1]);
        return integer + "圆" + decimal;
    }

    public static void main(String[] rgs) {
//        System.out.print("请输入您的金额：");
//        Scanner sc = new Scanner(System.in);
//        double num = sc.nextDouble();
//        sc.close();

        double num = 12340567.5;
        System.out.println(parse(num));
    }

}