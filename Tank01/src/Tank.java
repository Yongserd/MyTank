import java.awt.*;
import java.util.Random;

/**
 * @author liangshan @ClassName Tank
 * @description
 * @date 2021/2/25 0:09
 */
public class Tank {
  int x;
  int y;
  Dir dir;
  private static final int speed = 5;
  private boolean moving = true; // 是否处于静止
  private TankFrame tankFrame;
  private static final int WIDTH = ResouceMgr.tankD.getWidth(null);
  private static final int HEIGHT = ResouceMgr.tankD.getHeight(null);
  private boolean live =true;
  private Random random = new Random();
  private Group group;

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public static int getWIDTH() {
    return WIDTH;
  }

  public static int getHEIGHT() {
    return HEIGHT;
  }

  public boolean isLive() {
    return live;
  }

  public void setLive(boolean live) {
    this.live = live;
  }

  public void setDir(Dir dir) {
    this.dir = dir;
  }

  public Dir getDir() {
    return this.dir;
  }

  public Tank(int x, int y, Dir dir,Group group,TankFrame tankFrame) {
    this.x = x;
    this.y = y;
    this.dir = dir;
    this.tankFrame = tankFrame;
    this.group = group;
  }

  public void paint(Graphics g) {
    if(!live){
      tankFrame.tanks.remove(this);
    }
    switch (dir){
      case LEFT:
        g.drawImage(ResouceMgr.tankL,x,y,null);
        break;
      case RIGHT:
        g.drawImage(ResouceMgr.tankR,x,y,null);
        break;
      case UP:
        g.drawImage(ResouceMgr.tankU,x,y,null);
        break;
        case DOWN:
        g.drawImage(ResouceMgr.tankD,x,y,null);
        break;
      default:
        break;
    }

    move();

  }

  public void move() {
    if (moving) {
      //边界检测
      if(this.group == Group.BAD ){
        if(this.x <= 0){
          this.dir = Dir.RIGHT;
        }
        if(this.x + WIDTH >= TankFrame.GAME_WIDTH){
          this.dir = Dir.LEFT;
        }
        if(this.y <= 0){
          this.dir = Dir.DOWN;
        }
        if(this.y + HEIGHT >= TankFrame.GAME_HEIGHT){
          this.dir = Dir.UP;
        }
      }

      switch (dir) {
        case LEFT:
          x -= speed;
          break;
        case RIGHT:
          x += speed;
          break;
        case UP:
          y -= speed;
          break;
        case DOWN:
          y += speed;
          break;
      }
    }
    if(random.nextInt(10) > 8 && this.group == Group.BAD){
      this.fire();
    }
    if(Group.BAD == this.group && random.nextInt(100) > 95){
      randomDir();
    }


  }

  private void randomDir() {
    this.dir = Dir.values()[random.nextInt(4)];
  }

  public void setMoving(boolean move) {
    this.moving = move;
  }

  public Group getGroup() {
    return group;
  }

  public void setGroup(Group group) {
    this.group = group;
  }

  public void fire() {
    int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
    int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
    tankFrame.bulletList.add(new Bullet(bX,bY,dir,this.group,tankFrame));
  }

  public void die() {
    this.live = false;
  }
}
