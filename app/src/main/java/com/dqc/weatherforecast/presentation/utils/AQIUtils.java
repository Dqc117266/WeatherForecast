package com.dqc.weatherforecast.presentation.utils;

public class AQIUtils {

    /**
     * 根据AQI值返回相应的空气质量描述
     * @param aqi 空气质量指数
     * @return 空气质量描述
     */
    public static String getAQIDescription(int aqi) {
        if (aqi >= 0 && aqi <= 50) {
            return "优";
        } else if (aqi >= 51 && aqi <= 100) {
            return "良";
        } else if (aqi >= 101 && aqi <= 150) {
            return "轻度污染";
        } else if (aqi >= 151 && aqi <= 200) {
            return "中度污染";
        } else if (aqi >= 201 && aqi <= 300) {
            return "重度污染";
        } else if (aqi >= 301 && aqi <= 500) {
            return "严重污染";
        } else {
            return "无效的AQI值";
        }
    }

}

