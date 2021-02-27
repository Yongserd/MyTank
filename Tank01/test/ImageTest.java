import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author liangshan
 * @ClassName ImageTest
 * @description
 * @date 2021/2/27 17:09
 **/
public class ImageTest {
    @Test
    void test(){
        BufferedImage imageIO;
        try {
            imageIO = ImageIO.read(new File("D:\\study\\MyTank\\Tank01\\src\\images\\BadTank1.png"));
            assertNotNull(imageIO);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
