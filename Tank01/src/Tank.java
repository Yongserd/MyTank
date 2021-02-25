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

  public void setDir(Dir dir) {
    this.dir = dir;
  }

  public Dir getDir() {
    return this.dir;
  }

  public Tank(int x, int y, Dir dir) {
    this.x = x;
    this.y = y;
    this.dir = dir;
  }

  public void paint(Graphics g) {
    g.fillRect(x, y, 50, 50);
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
}
