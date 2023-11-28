package com.example.untitled7.task;

import com.example.untitled7.dao.BrokenPriceGoodsDao;
import com.example.untitled7.domain.BrokenPriceGoods;
import com.example.untitled7.service.BrokenPriceGoodsService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BrokenPriceGoodsTask {

    @Resource
    BrokenPriceGoodsService brokenPriceGoodsService;

    @Value("${Task.time.PulledBrokenPriceGoods.TimeDifference}")
    Long timeDifference;//已获取的链接  超过多少秒；

    /**
    * @Description: 每隔60秒  就  将获取时间超过timeDifference秒的链接 状态重置(重置为未获取);
    * @Author: CCYT
    * @Date: 2023/11/23
    */
    @Scheduled(fixedDelay =  60000L)
    public void executeTask(){
        Integer rows = brokenPriceGoodsService.resetExpiredLinkStatus(timeDifference);
//        System.out.println("已重置链接行数:"+rows);
    }
}
