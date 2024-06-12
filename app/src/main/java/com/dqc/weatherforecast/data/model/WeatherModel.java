package com.dqc.weatherforecast.data.model;

import java.util.List;

public class WeatherModel {

    /**
     * message : success感谢又拍云(upyun.com)提供CDN赞助
     * status : 200
     * date : 20240612
     * time : 2024-06-12 13:08:23
     * cityInfo : {"city":"天津市","citykey":"101030100","parent":"天津","updateTime":"12:48"}
     * data : {"shidu":"40%","pm25":30,"pm10":70,"quality":"轻度","wendu":"35.8","ganmao":"儿童、老年人及心脏、呼吸系统疾病患者人群应减少长时间或高强度户外锻炼","forecast":[{"date":"12","high":"高温 36℃","low":"低温 24℃","ymd":"2024-06-12","week":"星期三","sunrise":"04:44","sunset":"19:37","aqi":114,"fx":"东南风","fl":"3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"13","high":"高温 38℃","low":"低温 25℃","ymd":"2024-06-13","week":"星期四","sunrise":"04:44","sunset":"19:38","aqi":86,"fx":"东南风","fl":"3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"14","high":"高温 32℃","low":"低温 23℃","ymd":"2024-06-14","week":"星期五","sunrise":"04:44","sunset":"19:38","aqi":65,"fx":"东北风","fl":"3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"15","high":"高温 32℃","low":"低温 21℃","ymd":"2024-06-15","week":"星期六","sunrise":"04:44","sunset":"19:38","aqi":76,"fx":"东北风","fl":"3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"16","high":"高温 35℃","low":"低温 22℃","ymd":"2024-06-16","week":"星期日","sunrise":"04:44","sunset":"19:39","aqi":85,"fx":"南风","fl":"2级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"17","high":"高温 33℃","low":"低温 20℃","ymd":"2024-06-17","week":"星期一","sunrise":"04:44","sunset":"19:39","aqi":79,"fx":"西南风","fl":"3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"18","high":"高温 36℃","low":"低温 22℃","ymd":"2024-06-18","week":"星期二","sunrise":"04:44","sunset":"19:39","aqi":74,"fx":"东风","fl":"4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"19","high":"高温 34℃","low":"低温 26℃","ymd":"2024-06-19","week":"星期三","sunrise":"04:45","sunset":"19:40","aqi":57,"fx":"东南风","fl":"2级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"20","high":"高温 34℃","low":"低温 25℃","ymd":"2024-06-20","week":"星期四","sunrise":"04:45","sunset":"19:40","aqi":67,"fx":"东南风","fl":"2级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"21","high":"高温 41℃","low":"低温 22℃","ymd":"2024-06-21","week":"星期五","sunrise":"04:45","sunset":"19:40","aqi":66,"fx":"南风","fl":"3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"22","high":"高温 33℃","low":"低温 27℃","ymd":"2024-06-22","week":"星期六","sunrise":"04:45","sunset":"19:40","aqi":64,"fx":"西南风","fl":"3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"23","high":"高温 38℃","low":"低温 26℃","ymd":"2024-06-23","week":"星期日","sunrise":"04:46","sunset":"19:40","aqi":74,"fx":"东南风","fl":"2级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"24","high":"高温 38℃","low":"低温 24℃","ymd":"2024-06-24","week":"星期一","sunrise":"04:46","sunset":"19:41","aqi":73,"fx":"东南风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"25","high":"高温 37℃","low":"低温 26℃","ymd":"2024-06-25","week":"星期二","sunrise":"04:46","sunset":"19:41","aqi":70,"fx":"东南风","fl":"3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"26","high":"高温 37℃","low":"低温 25℃","ymd":"2024-06-26","week":"星期三","sunrise":"04:46","sunset":"19:41","aqi":83,"fx":"东南风","fl":"3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"}],"yesterday":{"date":"11","high":"高温 41℃","low":"低温 22℃","ymd":"2024-06-11","week":"星期二","sunrise":"04:44","sunset":"19:37","aqi":63,"fx":"西南风","fl":"3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"}}
     */

    private String message;
    private int status;
    private String date;
    private String time;
    private CityInfoModel cityInfo;
    private DataModel data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CityInfoModel getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfoModel cityInfo) {
        this.cityInfo = cityInfo;
    }

    public DataModel getData() {
        return data;
    }

    public void setData(DataModel data) {
        this.data = data;
    }

    public static class CityInfoModel {
        /**
         * city : 天津市
         * citykey : 101030100
         * parent : 天津
         * updateTime : 12:48
         */

        private String city;
        private String citykey;
        private String parent;
        private String updateTime;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCitykey() {
            return citykey;
        }

        public void setCitykey(String citykey) {
            this.citykey = citykey;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }

    public static class DataModel {
        /**
         * shidu : 40%
         * pm25 : 30.0
         * pm10 : 70.0
         * quality : 轻度
         * wendu : 35.8
         * ganmao : 儿童、老年人及心脏、呼吸系统疾病患者人群应减少长时间或高强度户外锻炼
         * forecast : [{"date":"12","high":"高温 36℃","low":"低温 24℃","ymd":"2024-06-12","week":"星期三","sunrise":"04:44","sunset":"19:37","aqi":114,"fx":"东南风","fl":"3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"13","high":"高温 38℃","low":"低温 25℃","ymd":"2024-06-13","week":"星期四","sunrise":"04:44","sunset":"19:38","aqi":86,"fx":"东南风","fl":"3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"14","high":"高温 32℃","low":"低温 23℃","ymd":"2024-06-14","week":"星期五","sunrise":"04:44","sunset":"19:38","aqi":65,"fx":"东北风","fl":"3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"15","high":"高温 32℃","low":"低温 21℃","ymd":"2024-06-15","week":"星期六","sunrise":"04:44","sunset":"19:38","aqi":76,"fx":"东北风","fl":"3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"16","high":"高温 35℃","low":"低温 22℃","ymd":"2024-06-16","week":"星期日","sunrise":"04:44","sunset":"19:39","aqi":85,"fx":"南风","fl":"2级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"17","high":"高温 33℃","low":"低温 20℃","ymd":"2024-06-17","week":"星期一","sunrise":"04:44","sunset":"19:39","aqi":79,"fx":"西南风","fl":"3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"18","high":"高温 36℃","low":"低温 22℃","ymd":"2024-06-18","week":"星期二","sunrise":"04:44","sunset":"19:39","aqi":74,"fx":"东风","fl":"4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"19","high":"高温 34℃","low":"低温 26℃","ymd":"2024-06-19","week":"星期三","sunrise":"04:45","sunset":"19:40","aqi":57,"fx":"东南风","fl":"2级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"20","high":"高温 34℃","low":"低温 25℃","ymd":"2024-06-20","week":"星期四","sunrise":"04:45","sunset":"19:40","aqi":67,"fx":"东南风","fl":"2级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"21","high":"高温 41℃","low":"低温 22℃","ymd":"2024-06-21","week":"星期五","sunrise":"04:45","sunset":"19:40","aqi":66,"fx":"南风","fl":"3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"22","high":"高温 33℃","low":"低温 27℃","ymd":"2024-06-22","week":"星期六","sunrise":"04:45","sunset":"19:40","aqi":64,"fx":"西南风","fl":"3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"23","high":"高温 38℃","low":"低温 26℃","ymd":"2024-06-23","week":"星期日","sunrise":"04:46","sunset":"19:40","aqi":74,"fx":"东南风","fl":"2级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"24","high":"高温 38℃","low":"低温 24℃","ymd":"2024-06-24","week":"星期一","sunrise":"04:46","sunset":"19:41","aqi":73,"fx":"东南风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"25","high":"高温 37℃","low":"低温 26℃","ymd":"2024-06-25","week":"星期二","sunrise":"04:46","sunset":"19:41","aqi":70,"fx":"东南风","fl":"3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"26","high":"高温 37℃","low":"低温 25℃","ymd":"2024-06-26","week":"星期三","sunrise":"04:46","sunset":"19:41","aqi":83,"fx":"东南风","fl":"3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"}]
         * yesterday : {"date":"11","high":"高温 41℃","low":"低温 22℃","ymd":"2024-06-11","week":"星期二","sunrise":"04:44","sunset":"19:37","aqi":63,"fx":"西南风","fl":"3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"}
         */

        private String shidu;
        private double pm25;
        private double pm10;
        private String quality;
        private String wendu;
        private String ganmao;
        private YesterdayModel yesterday;
        private List<ForecastModel> forecast;

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

        public double getPm25() {
            return pm25;
        }

        public void setPm25(double pm25) {
            this.pm25 = pm25;
        }

        public double getPm10() {
            return pm10;
        }

        public void setPm10(double pm10) {
            this.pm10 = pm10;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public YesterdayModel getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayModel yesterday) {
            this.yesterday = yesterday;
        }

        public List<ForecastModel> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastModel> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayModel {
            /**
             * date : 11
             * high : 高温 41℃
             * low : 低温 22℃
             * ymd : 2024-06-11
             * week : 星期二
             * sunrise : 04:44
             * sunset : 19:37
             * aqi : 63
             * fx : 西南风
             * fl : 3级
             * type : 多云
             * notice : 阴晴之间，谨防紫外线侵扰
             */

            private String date;
            private String high;
            private String low;
            private String ymd;
            private String week;
            private String sunrise;
            private String sunset;
            private int aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getYmd() {
                return ymd;
            }

            public void setYmd(String ymd) {
                this.ymd = ymd;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }

        public static class ForecastModel {
            /**
             * date : 12
             * high : 高温 36℃
             * low : 低温 24℃
             * ymd : 2024-06-12
             * week : 星期三
             * sunrise : 04:44
             * sunset : 19:37
             * aqi : 114
             * fx : 东南风
             * fl : 3级
             * type : 晴
             * notice : 愿你拥有比阳光明媚的心情
             */

            private String date;
            private String high;
            private String low;
            private String ymd;
            private String week;
            private String sunrise;
            private String sunset;
            private int aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getYmd() {
                return ymd;
            }

            public void setYmd(String ymd) {
                this.ymd = ymd;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }
    }
}
