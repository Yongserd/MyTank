import java.awt.*;

/**
 * @author liangshan
 * @ClassName Bullet
 * @description
 * @date 2021/2/25 23:29
 **/
public class Bullet {
    private int speed = 10;
    private Dir dir;
    private int x,y;
    public static final int WIDTH = ResouceMgr.bulletD.getWidth(null);
    public static final int HEIGHT = ResouceMgr.bulletD.getHeight(null);
    private boolean live = true;
    private TankFrame tankFrame;
    private Group group;

    public Bullet(int x,int y,Dir dir,Group group,TankFrame tankFrame){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g){
        if(!live){
            tankFrame.bulletList.remove(this);
        }
        switch (dir){
            case LEFT:
                g.drawImage(ResouceMgr.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResouceMgr.bulletR,x,y,null);
                break;
            case UP:
                g.drawImage(ResouceMgr.bulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResouceMgr.bulletD,x,y,null);
                break;
            default:
                break;
        }
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void collideWith(Tank tank) {
        //默认不开启队友伤害
        if (tank.getGroup() == this.group){
            return;
        }

        Rectangle bullet = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
        Rectangle tank1 = new Rectangle(tank.getX(), tank.getY(), Tank.getWIDTH(), Tank.getHEIGHT());
        if(bullet.intersects(tank1)){
            tank.setLive(false);
            this.live = false;
        }
    }
}
