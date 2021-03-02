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
  private static final int WIDTH = ResouceMgr.goodTankU.getWidth();
  private static final int HEIGHT = ResouceMgr.goodTankU.getHeight();
  private boolean live =true;
  private Random random = new Random();
  private Group group;
  private Rectangle rectangle;

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public Rectangle getRectangle() {
    return rectangle;
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
    rectangle = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
  }

  public void paint(Graphics g) {
    if(!live){
      tankFrame.tanks.remove(this);
    }
    switch (dir){
      case LEFT:
        g.drawImage(this.group == Group.GOOD ? ResouceMgr.goodTankL : ResouceMgr.badTankL,x,y,null);
        break;
      case RIGHT:
        g.drawImage(this.group == Group.GOOD ? ResouceMgr.goodTankR : ResouceMgr.badTankR,x,y,null);
        break;
      case UP:
        g.drawImage(this.group == Group.GOOD ? ResouceMgr.goodTankU : ResouceMgr.badTankU,x,y,null);
        break;
      case DOWN:
        g.drawImage(this.group == Group.GOOD ? ResouceMgr.goodTankD : ResouceMgr.badTankD,x,y,null);
        break;
      default:
        break;
    }

    move();

  }

  public void move() {
    if (moving) {
      //边界检测
      boundaryCheck();
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

    rectangle.x = this.x;
    rectangle.y = this.y;

    if(random.nextInt(10) > 8 && this.group == Group.BAD){
      this.fire();
    }
    if(Group.BAD == this.group && random.nextInt(100) > 95){
      randomDir();
    }


  }

  private void boundaryCheck() {
    if(this.x <= 5){
      this.x = 5;
    }
    if(this.x + WIDTH >= TankFrame.GAME_WIDTH -5){
      this.x = TankFrame.GAME_WIDTH - WIDTH - 5;
    }
    if(this.y <= 35){
      this.y = 35;
    }
    if(this.y + HEIGHT >= TankFrame.GAME_HEIGHT -5){
      this.y = TankFrame.GAME_HEIGHT - HEIGHT - 5;
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
