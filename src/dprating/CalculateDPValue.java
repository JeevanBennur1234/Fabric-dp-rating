package dprating;
import java.awt.image.*;

public class CalculateDPValue {

    double riplica;
    static double[] rem = new double[6];
    int count = 0;

    public void calculateRGB(BufferedImage nm) {
        rem[0] = 169845.0;
        rem[1] = 50000.0;
        rem[2] = 15000;
        rem[3] = 7000;
        rem[4] = 2500.0;
        rem[5] = 1500;

        count = 0;
        try {
            BufferedImage img = nm;
            int col, red, green, blue;
            int w = img.getWidth();
            int h = img.getHeight();

            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    col = img.getRGB(i, j);
                    red   = (col & 0x00ff0000) >> 16;
                    green = (col & 0x0000ff00) >> 8;
                    blue  =  col & 0x000000ff;

                    if (red == 255 && green == 255 && blue == 255) {
                        count++;
                    }
                }
            }
            riplica = count;
            System.out.println("riplica count = " + riplica);
        } catch (Exception e) {}
    }

    public float category() {
        float range = 0.0f;
        if      (riplica > 169845.0) range = 1.0f;
        else if (riplica > 139883.0) range = 1.15f;
        else if (riplica > 109922.0) range = 1.5f;
        else if (riplica > 79961.0)  range = 1.75f;
        else if (riplica > 50000.0)  range = 2.0f;
        else if (riplica > 41250.0)  range = 2.15f;
        else if (riplica > 32500.0)  range = 2.5f;
        else if (riplica > 25750.0)  range = 2.75f;
        else if (riplica > 19000.0)  range = 3.0f;
        else if (riplica > 13500.0)  range = 3.15f;
        else if (riplica > 8000.0)   range = 3.5f;
        else if (riplica > 5250.0)   range = 3.75f;
        else if (riplica > 2500.0)   range = 4.0f;
        else if (riplica > 2250.0)   range = 4.15f;
        else if (riplica > 2000.0)   range = 4.5f;
        else if (riplica > 1500.0)   range = 4.75f;
        else                         range = 5.0f;
        return range;
    }
}
