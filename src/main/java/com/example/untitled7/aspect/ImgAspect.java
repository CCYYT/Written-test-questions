package com.example.untitled7.aspect;

import com.example.untitled7.dao.ImgDao;
import jakarta.annotation.Resource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
* 图片服务切面
* 用来增强保存图片的功能。
* 增强点：
*   1.保存图片后  添加时间水印
* */
@Aspect
@Component
public class ImgAspect {

    @Resource
    ImgDao imgDao;

    @Pointcut("execution(String com.example.untitled7.service.impl.ImgServiceImpl.saveImg(..))")
    public void saveImgPointcut(){}

    @Around("saveImgPointcut()")
    public String doAfter(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String path =(String) proceedingJoinPoint.proceed();
        if (path == null) return path;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String watermarkText = dateFormat.format(new Date());
        imgDao.drawWatermark(path,watermarkText);
        return path;
    }
}
