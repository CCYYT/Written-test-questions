package com.example.untitled7.task;

import com.example.untitled7.dao.BrokenPriceGoodsDao;
import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BrokenPriceGoodsTask {

    @Resource
    BrokenPriceGoodsDao brokenPriceGoodsDao;

    /**
    * @Description: 每隔60秒将已经被获取的链接重置
    * @Author: CCYT
    * @Date: 2023/11/23
    */
    @Scheduled(fixedDelay =  60000L)
    public void executeTask(){
        brokenPriceGoodsDao.PulledBrokenPriceGoodsToBrokenPriceGoods();
    }
}
