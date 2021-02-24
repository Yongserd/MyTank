import java.awt.*;

/**
 * @author liangshan
 * @ClassName Tank
 * @description
 * @date 2021/2/25 0:09
 **/
public class Tank {
    int x;
    int y;
    Dir dir;
    private static final int speed = 10;

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Tank(int x, int y, Dir dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g){
        g.fillRect(x,y,50,50);
        switch (dir) {
            case LEFT:
                x-=speed;
                break;
            case RIGHT:
                x+=speed;
                break;
            case UP:
                y-=speed;
                break;
            case DOWN:
                y+=speed;
                break;
        }
    }
}
