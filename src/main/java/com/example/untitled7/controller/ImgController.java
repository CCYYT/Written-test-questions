package com.example.untitled7.controller;

import com.example.untitled7.common.ResultImg;
import com.example.untitled7.domain.Img;
import com.example.untitled7.service.ImgService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImgController {
    @Resource
    ImgService imgService;

    @PostMapping("uploadImg")
    public ResultImg uploadImg(@RequestBody Img img){
        String url = imgService.saveImg(img);
        return url!=null?ResultImg.ok(url):ResultImg.fail();
    }
}
