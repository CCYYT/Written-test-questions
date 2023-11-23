package com.example.untitled7;

import com.example.untitled7.dao.BrokenPriceGoodsDao;
import com.example.untitled7.dao.ImgDao;
import com.example.untitled7.domain.BrokenPriceGoods;
import com.example.untitled7.domain.Img;
import com.example.untitled7.service.ImgService;
import jakarta.annotation.Resource;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Untitled7ApplicationTests {

    @Resource
    BrokenPriceGoodsDao brokenPriceGoodsDao;

    @Resource
    ImgDao imgDao;
    @Resource
    ImgService imgService;

//    @Test
    void contextLoads() {
//        List<CSVRecord> records = brokenPriceGoodsDao.getRecords();
//        for (CSVRecord record : records) {
//            System.out.println(record);
//        }
//        BrokenPriceGoods b = brokenPriceGoodsDao.getBrokenPriceGoodsByPlatformAndBatchNo("京东", "2023102801");
//        System.out.println(b);
    }
//    @Test
    void imgDao(){
        Img img = new Img(){{
            setImg("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");
            setId(1);
        }};
        System.out.println(imgService.saveImg(img));
    }

}