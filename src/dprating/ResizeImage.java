/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dprating;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;
import java.awt.*;

public class ResizeImage
{
      public static BufferedImage resize(File icon) {
      try {
           BufferedImage originalImage = ImageIO.read(icon);
            
           originalImage= Scalr.resize(originalImage, Scalr.Method.QUALITY, Scalr.Mode.FIT_EXACT, 2272, 1704);
           
         
			
	   Graphics2D gg = originalImage.createGraphics();
           gg.drawImage(originalImage, 0, 0, originalImage.getWidth(null), originalImage.getHeight(null), null);
		     
            return originalImage;
                
        } catch (Exception e) {
            System.out.println(""+e);
           return null;
        }


    
    }
    
}
