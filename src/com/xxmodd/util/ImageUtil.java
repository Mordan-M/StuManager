package com.xxmodd.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 图片工具类
 * @author Hallbow
 *
 */
public class ImageUtil {
	/**  
     * 根据设置的宽高等比例压缩图片文件<br> 先保存原文件，再压缩、上传  
     * @param oldFile  要进行压缩的文件  
     * @param newFile  新文件  
     * @param width  宽度 //设置宽度时（高度传入0，等比例缩放）  
     * @param height 高度 //设置高度时（宽度传入0，等比例缩放）  
     * @return 返回压缩后的文件的全路径  
     */    
    public static String zipImageFile(File oldFile,File newFile, int width, int height) {    
        if (oldFile == null) {    
            return null;    
        }    
        try {    
            Image srcFile = ImageIO.read(oldFile);    
            int w = srcFile.getWidth(null);    
            int h = srcFile.getHeight(null);    
            double bili;    
            if(width>0){    
                bili=width/(double)w;    
                height = (int) (h*bili);    
            }else{    
                if(height>0){    
                    bili=height/(double)h;    
                    width = (int) (w*bili);    
                }    
            }    
              
            String srcImgPath = newFile.getAbsoluteFile().toString();  
//            System.out.println(srcImgPath);
            String subfix = "jpg";  
            subfix = srcImgPath.substring(srcImgPath.lastIndexOf(".")+1,srcImgPath.length());  
  
            BufferedImage buffImg = null;   
            if(subfix.equals("png")){  
                buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);  
            }else{  
                buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
            }  
  
            Graphics2D graphics = buffImg.createGraphics();  
            graphics.setBackground(new Color(255,255,255));  
            graphics.setColor(new Color(255,255,255));  
            graphics.fillRect(0, 0, width, height);  
            graphics.drawImage(srcFile.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);    
  
            ImageIO.write(buffImg, subfix, new File(srcImgPath));    
    
        } catch (FileNotFoundException e) {    
            e.printStackTrace();    
        } catch (IOException e) {    
            e.printStackTrace();    
        }    
        return newFile.getAbsolutePath();    
    }    
   
}