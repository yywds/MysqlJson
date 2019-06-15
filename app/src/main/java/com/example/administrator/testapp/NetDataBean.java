package com.example.administrator.testapp;

import java.util.List;

/**
 * 使用GsonFormat插件快速生成
 */

public class NetDataBean {

    /**
     * imageArr : [{"ID":"1","IMAPAURL":"http://gwop.xtrich.com/xtApp/lexianghuo1.html","IMAURL":"http://100.68.227.22:8080/image/bug.png"},{"ID":"2","IMAPAURL":"http://gwop.xtrich.com/xtApp/new-plan.html","IMAURL":"http://192.168.191.1:8080/P2PInvest/images/index02.png"},{"ID":"3","IMAPAURL":"http://gwop.xtrich.com/xtApp/new-plan.html","IMAURL":"http://192.168.191.1:8080/P2PInvest/images/index03.png"},{"ID":"5","IMAPAURL":"http://gwop.xtrich.com/xtApp/twcx.html","IMAURL":"http://192.168.191.1:8080/P2PInvest/images/index04.png"}]
     * proInfo : {"id":"1","memberNum":"100","minTouMoney":"100","money":"10","name":"硅谷彩虹新手计划","progress":"90","suodingDays":"30","yearRate":"8.00","url":"http://100.68.227.22:8080/image/bug.png"}
     */

    private ProInfoBean proInfo;
    private List<ImageArrBean> imageArr;

    public ProInfoBean getProInfo() {
        return proInfo;
    }

    public void setProInfo(ProInfoBean proInfo) {
        this.proInfo = proInfo;
    }

    public List<ImageArrBean> getImageArr() {
        return imageArr;
    }

    public void setImageArr(List<ImageArrBean> imageArr) {
        this.imageArr = imageArr;
    }

    public static class ProInfoBean {
        /**
         * id : 1
         * memberNum : 100
         * minTouMoney : 100
         * money : 10
         * name : 硅谷彩虹新手计划
         * progress : 90
         * suodingDays : 30
         * yearRate : 8.00
         * url : http://100.68.227.22:8080/image/bug.png
         */

        private String id;
        private String memberNum;
        private String minTouMoney;
        private String money;
        private String name;
        private String progress;
        private String suodingDays;
        private String yearRate;
        private String url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMemberNum() {
            return memberNum;
        }

        public void setMemberNum(String memberNum) {
            this.memberNum = memberNum;
        }

        public String getMinTouMoney() {
            return minTouMoney;
        }

        public void setMinTouMoney(String minTouMoney) {
            this.minTouMoney = minTouMoney;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProgress() {
            return progress;
        }

        public void setProgress(String progress) {
            this.progress = progress;
        }

        public String getSuodingDays() {
            return suodingDays;
        }

        public void setSuodingDays(String suodingDays) {
            this.suodingDays = suodingDays;
        }

        public String getYearRate() {
            return yearRate;
        }

        public void setYearRate(String yearRate) {
            this.yearRate = yearRate;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class ImageArrBean {
        /**
         * ID : 1
         * IMAPAURL : http://gwop.xtrich.com/xtApp/lexianghuo1.html
         * IMAURL : http://100.68.227.22:8080/image/bug.png
         */

        private String ID;
        private String IMAPAURL;
        private String IMAURL;

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getIMAPAURL() {
            return IMAPAURL;
        }

        public void setIMAPAURL(String IMAPAURL) {
            this.IMAPAURL = IMAPAURL;
        }

        public String getIMAURL() {
            return IMAURL;
        }

        public void setIMAURL(String IMAURL) {
            this.IMAURL = IMAURL;
        }
    }
}
