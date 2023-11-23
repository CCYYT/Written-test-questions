package com.example.untitled7.dao;

import com.example.untitled7.domain.Img;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@Component
public class ImgDao {
    @Value("${Img.SavePath}")
    String imgSavePath;
//    String imgSavePath = this.getClass().getClassLoader().getResource("snapshot/").getPath();

    public String saveImg(Img img) {
        try {
            byte[] imageBytes = Base64.getDecoder().decode(img.getImg());
            Files.write(Paths.get(imgSavePath+"/"+img.getId()+".jpg"),imageBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imgSavePath+"/"+img.getId()+".jpg";
    }

    public void drawWatermark(String path,String watermarkText){
        try {
            // 读取原始图片
            BufferedImage originalImage = ImageIO.read(new FileInputStream(path));
            // 创建画布
            BufferedImage bufferedImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = bufferedImage.createGraphics();
            // 绘制原始图片
            g2d.drawImage(originalImage, 0, 0, null);

            // 设置水印文字的样式和位置
            g2d.setFont(new Font("微软雅黑", Font.BOLD, 10));
            g2d.setColor(Color.BLACK);
            g2d.drawString(watermarkText,10,originalImage.getHeight()/2);
            // 释放画布资源
            g2d.dispose();

            // 保存带有水印的图片
            FileOutputStream outImgStream = new FileOutputStream(path);
            ImageIO.write(bufferedImage, "jpg", outImgStream);
            outImgStream.flush();
            outImgStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
