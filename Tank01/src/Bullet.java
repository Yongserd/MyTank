import java.awt.*;

/**
 * @author liangshan
 * @ClassName Bullet
 * @description
 * @date 2021/2/25 23:29
 **/
public class Bullet {
    private int speed = 1;
    private Dir dir;
    private int x,y;
    private static final int WIDTH = 30;
    private static final int HEIGHT = 30;
    private boolean live = true;
    private TankFrame tankFrame;

    public Bullet(int x,int y,Dir dir,TankFrame tankFrame){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g){
        if(!live){
            tankFrame.bulletList.remove(this);
        }
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(c);
        move();
    }

    private void move(){
        switch (dir){
            case LEFT:
                this.x-=speed;
                break;
            case RIGHT:
                this.x+=speed;
                break;
            case UP:
                this.y-=speed;
                break;
            case DOWN:
                this.y+=speed;
        }
        //判断子弹是否存活
        if(this.x >TankFrame.GAME_WIDTH || this.y > TankFrame.GAME_HEIGHT || this.x < 0 || this.y < 0){
            live = false;
        }
    }
}
