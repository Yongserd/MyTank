import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author liangshan
 * @ClassName T
 * @description 认识Frame类
 * @date 2021/2/23 14:13
 **/
public class T {
  public static void main(String[] args) {
    //创建窗口
      Frame frame = new Frame();
      frame.setSize(800,600);//设置窗口大小
      frame.setResizable(true);//设置窗口是否可改变大小
      frame.setTitle("Tank War!");
      frame.setVisible(true);//设置窗口可见
      frame.addWindowListener(new WindowAdapter() {
          //监听窗口关闭事件
          @Override
          public void windowClosing(WindowEvent e) {
            System.exit(0);
          }


      });
  }
}
