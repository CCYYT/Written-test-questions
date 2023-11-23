package com.example.untitled7.service.impl;

import com.example.untitled7.dao.BrokenPriceGoodsDao;
import com.example.untitled7.dao.ImgDao;
import com.example.untitled7.domain.Img;
import com.example.untitled7.service.ImgService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ImgServiceImpl implements ImgService {

    @Resource
    ImgDao imgDao;
    @Resource
    BrokenPriceGoodsDao brokenPriceGoodsDao;

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
        return brokenPriceGoodsDao.delPulledBrokenPriceGoods(img.getSku_id())==null?null:imgDao.saveImg(img);
    }
}
