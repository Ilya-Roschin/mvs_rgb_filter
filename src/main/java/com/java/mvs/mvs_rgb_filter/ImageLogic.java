package com.java.mvs.mvs_rgb_filter;



import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLogic {

    private static BufferedImage START_IMAGE = null;

    public void setStartImage(String path) {
        try {
            java.awt.Image image = ImageIO.read(new File(path));
            BufferedImage bufferedImage = toBufferedImage(image);
            START_IMAGE = toBufferedImage(image);
        } catch (IOException e) {
            System.out.println("Ошибка чтения изображения");
        }
    }

    public BufferedImage toGrayImage(BufferedImage bufferedImage) {
        if(START_IMAGE != null) {
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();

            BufferedImage grayBufferedImage = new BufferedImage(width, height, bufferedImage.getType());
            for (int i = 0; i < bufferedImage.getWidth(); i++) {
                for (int j = 0; j < bufferedImage.getHeight(); j++) {
                    final int color = bufferedImage.getRGB(i, j);
                    final int r = (color >> 16) & 0xff;
                    final int g = (color >> 8) & 0xff;
                    final int b = color & 0xff;
                    int gray = (int) (0.3 * r + 0.59 * g + 0.11 * b);
                    int newPixel = colorToRGB(255, gray, gray, gray);
                    grayBufferedImage.setRGB(i, j, newPixel);
                }
            }
            createFile(grayBufferedImage);

        } else {
            System.out.println("картинка не загружена");
        }
    }

    private void createFile(BufferedImage bufferedImage) {
        File outFile = new File("src/main/java/com/java/mvs/mvs_rgb_filter/test_filter.png");
        try {
            ImageIO.write(bufferedImage, "png", outFile);
            System.out.println("Файл успешно создан");
        } catch (IOException e) {
            System.out.println("Ошибка записи файла");
        }
    }

    private int colorToRGB(int alpha, int red, int green, int blue) {

        int newPixel = 0;
        newPixel += alpha;
        newPixel = newPixel << 8;
        newPixel += red;
        newPixel = newPixel << 8;
        newPixel += green;
        newPixel = newPixel << 8;
        newPixel += blue;

        return newPixel;
    }


    private BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics = bimage.createGraphics();
        graphics.drawImage(img, 0, 0, null);
        graphics.dispose();

        return bimage;
    }


}
