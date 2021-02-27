import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * @author liangshan
 * @ClassName ResouceMgr
 * @description
 * @date 2021/2/27 22:14
 **/
public class ResouceMgr {
    public static Image tankL,tankR,tankU,tankD;
    public static Image bulletL,bulletR,bulletU,bulletD;

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
