package com.example.untitled7.service.impl;

import com.example.untitled7.dao.BrokenPriceGoodsDao;
import com.example.untitled7.domain.BrokenPriceGoods;
import com.example.untitled7.service.BrokenPriceGoodsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BrokenPriceGoodsServiceImpl implements BrokenPriceGoodsService {
    @Resource
    BrokenPriceGoodsDao brokenPriceGoodsDao;

    /*
    * 获取破价链接
    * */
    @Transactional
    @Override
    public synchronized List<BrokenPriceGoods> getBrokenPriceGoodsByPlatformAndBatchNoAndCount(String platform, String batchNo, Integer count) {
        List<BrokenPriceGoods> brokenPriceGoodsList = brokenPriceGoodsDao.queryByPlatformAndBatchNoAndCount(platform, batchNo, count,BrokenPriceGoods.STATUS.NotObtained);
        if(brokenPriceGoodsList.isEmpty()) return null;//获取到的链接 为空
        List<Integer> ids = new ArrayList<>(count);
        brokenPriceGoodsList.forEach(brokenPriceGoods -> ids.add(brokenPriceGoods.getId()));
        //将获取到的链接状态都设置为已获取
        Integer rows = brokenPriceGoodsDao.batchSetStatusByIds(ids, BrokenPriceGoods.STATUS.Obtained);
        if (!Objects.equals(rows,count)) throw new RuntimeException("修改异常   预计修改的行数:"+brokenPriceGoodsList.size()+"   |||    实际修改的行数："+rows);
        return brokenPriceGoodsList;
    }

    /**
     * @Description: 将获取时间超过timeDifference秒的链接 状态重置(重置为未获取);
     *                 注意： 执行该方法会造成锁表， 尽量减少调用的次数
     * @Param: [timeDifference 已获取的链接  超过多少秒；]
     * @return： java.lang.Integer  影响的行数
     * @Author: CCYT
     */
    @Transactional
    @Override
    public Integer resetExpiredLinkStatus(Long timeDifference){
        return brokenPriceGoodsDao.batchSetStatusByThroughTimeDifference(timeDifference, BrokenPriceGoods.STATUS.Obtained,BrokenPriceGoods.STATUS.NotObtained);
    }

    /**
     * @Description: 将链接的状态设置为已完成  注：这里使用事务是为了 加行锁，不被重置链接的操作影响。
     * @Param: [sku_id]
     * @return： java.lang.Integer 影响的行数
     * @Author: CCYT
     */
    @Transactional
    @Override
    public Integer linkCompleted(String sku_id){
        return brokenPriceGoodsDao.setStatusBySkuId(sku_id, BrokenPriceGoods.STATUS.Completed);
     }
//    @Override
//    public boolean addBrokenPriceGoods(BrokenPriceGoods brokenPriceGoods) {
//        return brokenPriceGoodsDao.addBrokenPriceGoods(brokenPriceGoods);
//    }
}
