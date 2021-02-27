import java.awt.*;

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
  private boolean moving = false; // 是否处于静止
  private TankFrame tankFrame;
  private static final int WIDTH = ResouceMgr.tankD.getWidth(null);
  private static final int HEIGHT = ResouceMgr.tankD.getHeight(null);
  public void setDir(Dir dir) {
    this.dir = dir;
  }

  public Dir getDir() {
    return this.dir;
  }

  public Tank(int x, int y, Dir dir,TankFrame tankFrame) {
    this.x = x;
    this.y = y;
    this.dir = dir;
    this.tankFrame = tankFrame;
  }

  public void paint(Graphics g) {
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
  }

  public void setMoving(boolean move) {
    this.moving = move;
  }

  public void fire() {
    int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
    int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
    tankFrame.bulletList.add(new Bullet(bX,bY,dir,tankFrame));
  }
}
