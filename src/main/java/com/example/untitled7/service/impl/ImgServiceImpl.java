package com.example.untitled7.service.impl;

import com.example.untitled7.dao.BrokenPriceGoodsDao;
import com.example.untitled7.dao.ImgDao;
import com.example.untitled7.domain.BrokenPriceGoods;
import com.example.untitled7.domain.Img;
import com.example.untitled7.service.BrokenPriceGoodsService;
import com.example.untitled7.service.ImgService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ImgServiceImpl implements ImgService {

    @Resource
    ImgDao imgDao;
    @Resource
    BrokenPriceGoodsService brokenPriceGoodsService;

        /**
        * @Description: 保存图像信息
        * @Param: [img:图像信息]
        * @return： java.lang.String:Path(保存的路径
        * @Author: CCYT
        * @Date: 2023/11/23
        */
    @Override
    public String saveImg(Img img) {
        //验证img中的Sku_id是否被获取    是被获取的就保存图片
//        return imgDao.saveImg(img);
        if(img.getSku_id() == null)return null;
        Integer rows = brokenPriceGoodsService.linkCompleted(img.getSku_id());
        return rows == 0?null:imgDao.saveImg(img);
    }
}
