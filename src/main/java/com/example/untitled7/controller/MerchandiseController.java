package com.example.untitled7.controller;

import com.example.untitled7.common.Result;
import com.example.untitled7.domain.BrokenPriceGoods;
import com.example.untitled7.service.BrokenPriceGoodsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MerchandiseController {
    @Resource
    BrokenPriceGoodsService brokenPriceGoodsService;

    /*
    * 批量获取破价链接
    * */
    @GetMapping("/breakPriceUrls")
    public Result breakPriceUrls(@RequestParam(value = "platform") String platform,
                                                   @RequestParam(value = "count",defaultValue = "10") Integer count,
                                                   @RequestParam(value = "batchNo") String batchNo){
        List<BrokenPriceGoods> brokenPriceGoodsList = brokenPriceGoodsService.getBrokenPriceGoodsByPlatformAndBatchNoAndCount(platform,batchNo,count);
        return brokenPriceGoodsList != null?Result.ok(brokenPriceGoodsList):Result.fail();
    }

//    /*
//    * 添加破价链接
//    * */
//    @PostMapping("/breakPriceUrls")
//    public Result breakPriceUrls(@RequestBody BrokenPriceGoods brokenPriceGoods){
//        return brokenPriceGoodsService.addBrokenPriceGoods(brokenPriceGoods)?Result.ok("ok"):Result.fail();
//    }

}
