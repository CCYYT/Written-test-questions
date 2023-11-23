package com.example.untitled7.domain;
/*
* 破价商品
* */
public class BrokenPriceGoods {
    private Integer id;
    private String pageUrl;//商品链接
    private String batchNo;//批次号
    private String sku_id;
    private String platform;//平台

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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "BrokenPriceGoods{" +
                "id=" + id +
                ", pageUrl='" + pageUrl + '\'' +
                ", batchNo='" + batchNo + '\'' +
                ", sku_id='" + sku_id + '\'' +
                ", platform='" + platform + '\'' +
                '}';
    }
}
