/**
 * @author liangshan @ClassName T
 * @description 认识Frame类
 * @date 2021/2/23 14:13
 */
public class Main {
  public static void main(String[] args) throws InterruptedException {
    // 创建tank窗口
    TankFrame tankFrame = new TankFrame();
    //加载配置
    int count = Integer.parseInt((String)PropertiesMgr.get("initTankCount"));
    // 敌方tank
    for (int i = 0; i < count; i++) {
      tankFrame.tanks.add(new Tank(200 + i * 80, 200, Dir.DOWN, Group.BAD, tankFrame));
    }
    // 每隔50毫秒刷新窗口
    for (; ; ) {
      Thread.sleep(25);
      tankFrame.repaint();
    }
  }
}
