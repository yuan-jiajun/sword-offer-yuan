package utils.src;

import jdk.nashorn.internal.ir.CallNode;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Yuan Jiajun
 * @description
 * @date 2020/7/16 21:28
 */
public class ReplaceFolderFilesName {
    public static String floderPath = "F:\\workspace\\sword-offer\\sword-offer-book\\src\\main\\java\\book";
    public static File folder = new File(floderPath);

    public static void main(String[] args) {
        File[] files = folder.listFiles();
        String initFileName = null;
        String newFileName = null;
        String tmp1 = null;
        String tmp2 = null;

        for (File file : files) {
//            System.out.println(file.getName());
            initFileName = file.getName();
            tmp1 = regexReturnMatchGroups(initFileName, "(\\D+)\\d+", 1);
            tmp2 = regexReturnMatchGroups(initFileName, "\\D+(\\d+)", 1);
            System.out.println(tmp1 + "\t" + tmp2);

            newFileName = floderPath + "_" + tmp2 + tmp1;
            System.out.println(newFileName);

            File newFile = new File(newFileName);
            if (newFile.exists()) {
                System.out.println("文件已存在");
                return;
            }
            if (!file.renameTo(newFile)) {
                System.out.println("Failed to renameTo file");
            }
        }
    }

    public static String regexReturnMatchGroups(String string, String regEx, int groupId) {
        StringBuilder matchStringBuilder = new StringBuilder();
        int groupCount;

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(string);
        groupCount = matcher.groupCount();

        if (groupId > groupCount) {
            System.out.println("GroupId输入错误1，请重新输入");
            return matchStringBuilder.toString();
        }
        while (matcher.find()) {
            try {
                matchStringBuilder.append(matcher.group(groupId)).append(" ");
            } catch (Exception e) {
                System.out.println("Matcher Exception.");
            }
        }
        return matchStringBuilder.toString().trim();
    }

}