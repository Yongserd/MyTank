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
            tankU = ImageIO.read(ResouceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            tankR = ImageUtil.rotateImage(tankU,90);
            tankL = ImageUtil.rotateImage(tankU,-90);
            tankD = ImageUtil.rotateImage(tankU,180);
            bulletU = ImageIO.read(ResouceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletL = ImageUtil.rotateImage(bulletU, -90);
            bulletR = ImageUtil.rotateImage(bulletU, 90);
            bulletD = ImageUtil.rotateImage(bulletU, 180);
            boom = new BufferedImage[16];
          for (int i = 0; i < boom.length; i++) {
              boom[i] = ImageIO.read(ResouceMgr.class.getResourceAsStream("images/e" + (i + 1) +".gif"));
          }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
