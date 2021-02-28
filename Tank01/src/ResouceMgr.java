import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author liangshan
 * @ClassName ResouceMgr
 * @description
 * @date 2021/2/27 22:14
 **/
public class ResouceMgr {
    public static BufferedImage tankL,tankR,tankU,tankD;
    public static BufferedImage bulletL,bulletR,bulletU,bulletD;
    public static BufferedImage[] boom;
    static {
        try {
            tankL = ImageIO.read(ResouceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankR = ImageIO.read(ResouceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tankU = ImageIO.read(ResouceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankD = ImageIO.read(ResouceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            bulletL = ImageIO.read(ResouceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletR = ImageIO.read(ResouceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            bulletU = ImageIO.read(ResouceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletD = ImageIO.read(ResouceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            boom = new BufferedImage[16];
          for (int i = 0; i < boom.length; i++) {
              boom[i] = ImageIO.read(ResouceMgr.class.getResourceAsStream("images/e" + (i + 1) +".gif"));
          }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
