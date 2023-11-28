package com.example.untitled7.service;

import com.example.untitled7.domain.BrokenPriceGoods;

import java.util.List;

public interface BrokenPriceGoodsService {

    List<BrokenPriceGoods> getBrokenPriceGoodsByPlatformAndBatchNoAndCount(String platform, String batchNo, Integer count);
    Integer resetExpiredLinkStatus(Long timeDifference);

    Integer linkCompleted(String sku_id);


//    boolean addBrokenPriceGoods(BrokenPriceGoods brokenPriceGoods);
}
