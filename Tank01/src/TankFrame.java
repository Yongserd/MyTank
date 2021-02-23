import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author liangshan
 * @ClassName TankFrame
 * @description
 * @date 2021/2/23 15:11
 **/
public class TankFrame extends Frame {
    int x = 200;
    int y = 200;
    public TankFrame(){
        this.setResizable(true);//可调整大小
        this.setSize(800,600);//窗口大小
        this.setTitle("Tank War!");//标题
        this.setVisible(true);//可见
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    //重写paint方法，当窗口重新绘制的时候调用此方法
    @Override
    public void paint(Graphics g){
    System.out.println("paint!");
        g.fillRect(x,y,50,50);
        x += 50;
        y += 50;
    }

}
