package com.dqc.weatherforecast.presentation.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    /**
     * 提取字符串中的数字部分
     *
     * @param input 包含数字的字符串
     * @return 提取出的数字部分，如果没有找到数字则返回空字符串
     */
    public static String extractTemperature(String input) {
        // 使用正则表达式匹配数字
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return matcher.group();
        } else {
            return "";
        }
    }
}
