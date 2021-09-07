package br.com.pdi.vision;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BasicThreshold {

	BufferedImage image;
	int width, height, red, green, blue, gray;
	int threshold = 94;
	
	public void run() throws IOException {
		File input = new File("D:\\Users\\nirto\\Documents\\GitHub\\"+
							  "PDI\\pdi-atv-1\\src\\images\\image1.jfif");
		image = ImageIO.read(input);
		width = image.getWidth();
		height = image.getHeight();
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Color pixel = new Color(image.getRGB(j, i));
				
				red = pixel.darker().getRed();
				green = pixel.darker().darker().darker().getGreen();
				blue = pixel.getBlue();
				gray = ((red*3) + (green/4)-(blue*2))/3;
				if(gray > threshold) {
					image.setRGB(j, i, Color.WHITE.getRGB());
				}else {
					image.setRGB(j, i, Color.BLACK.getRGB());
					
				}
			}
		}
		
		File output = new File("D:\\Users\\nirto\\Documents\\GitHub\\"+
							  "PDI\\pdi-atv-1\\src\\images\\image1_bw2.jpg");
		ImageIO.write(image, "jpg", output);
		
		System.out.println("Done!");
		
	}
}
