

/**
 * @author liangshan
 * @ClassName T
 * @description 认识Frame类
 * @date 2021/2/23 14:13
 **/
public class Main {
  public static void main(String[] args) throws InterruptedException {
      //创建tank窗口
      TankFrame tankFrame = new TankFrame();

      //每隔50毫秒刷新窗口
      for(;;){
          Thread.sleep(50);
          tankFrame.repaint();
      }

  }

}
