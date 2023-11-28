package com.example.untitled7;

import com.example.untitled7.domain.BrokenPriceGoods;
import com.example.untitled7.service.BrokenPriceGoodsService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @program: IntelliJ IDEA
 * @description: 破价信息 测试
 * @author: CCYT
 **/
@SpringBootTest
public class BrokenPriceGoodsTest {

    @Resource
    BrokenPriceGoodsService b;

    @Test
    void test(){
        List<BrokenPriceGoods> goods = b.getBrokenPriceGoodsByPlatformAndBatchNoAndCount("京东","2023102801",10);

        goods.forEach(System.out::println);
    }

}
