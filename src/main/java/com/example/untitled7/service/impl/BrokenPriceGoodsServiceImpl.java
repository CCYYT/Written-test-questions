package com.example.untitled7.service.impl;

import com.example.untitled7.dao.BrokenPriceGoodsDao;
import com.example.untitled7.domain.BrokenPriceGoods;
import com.example.untitled7.service.BrokenPriceGoodsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrokenPriceGoodsServiceImpl implements BrokenPriceGoodsService {
    @Resource
    BrokenPriceGoodsDao brokenPriceGoodsDao;

    @Override
    public List<BrokenPriceGoods> getBrokenPriceGoodsByPlatformAndBatchNoAndCount(String platform, String batchNo, Integer count) {
        return brokenPriceGoodsDao.getBrokenPriceGoodsByPlatformAndBatchNoAndCount(platform, batchNo, count);
    }

    @Override
    public boolean addBrokenPriceGoods(BrokenPriceGoods brokenPriceGoods) {
        return brokenPriceGoodsDao.addBrokenPriceGoods(brokenPriceGoods);
    }
}
