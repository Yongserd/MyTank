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
    Color c = g.getColor();
    g.setColor(Color.YELLOW);
    g.fillRect(x, y, 50, 50);
    g.setColor(c);
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
    tankFrame.bulletList.add(new Bullet(x + 25,y + 25,dir,tankFrame));
  }
}
