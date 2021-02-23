import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
        //监听键盘
        addKeyListener(new MyKeyListener());

        //监听窗口关闭事件
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    class MyKeyListener extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("key pressed");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released");
        }
    }

    //重写paint方法，当窗口重新绘制的时候调用此方法
    @Override
    public void paint(Graphics g){
        g.fillRect(x,y,50,50);
        x += 50;
        y += 50;
    }

}
