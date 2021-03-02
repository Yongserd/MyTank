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
    public static BufferedImage goodTankL,goodTankR,goodTankU,goodTankD;
    public static BufferedImage badTankL,badTankR,badTankU,badTankD;
    public static BufferedImage bulletL,bulletR,bulletU,bulletD;
    public static BufferedImage[] boom;
    static {
        try {
            goodTankU = ImageIO.read(ResouceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankR = ImageUtil.rotateImage(goodTankU,90);
            goodTankL = ImageUtil.rotateImage(goodTankU,-90);
            goodTankD = ImageUtil.rotateImage(goodTankU,180);
            badTankU = ImageIO.read(ResouceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankR = ImageUtil.rotateImage(badTankU,90);
            badTankL = ImageUtil.rotateImage(badTankU,-90);
            badTankD = ImageUtil.rotateImage(badTankU,180);
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
