package com.example.untitled7.domain;
/*
* 破价商品
* */
public class BrokenPriceGoods {
    private Integer id;
    private String pageUrl;//商品链接
    private String batchNo;//批次号
    private String sku_id;
    private String platformName;//平台
    private Integer status;//链接状态
    private Long time;//获取到链接时的时间戳
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getSku_id() {
        return sku_id;
    }

    public void setSku_id(String sku_id) {
        this.sku_id = sku_id;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public static class STATUS{
        public static final Integer NotObtained = 0;//未获取的链接
        public static final Integer Obtained = 1;//已获取的链接
        public static final Integer Completed = 2;//上传了截图的链接
    }
}
