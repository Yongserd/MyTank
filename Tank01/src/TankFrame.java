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
    Dir dir = Dir.DOWN;
    private final int speed = 10;
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
        //定义tank移动方向
        boolean bl = false;
        boolean br = false;
        boolean bu = false;
        boolean bd = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    bl = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = true;
                    break;
                case KeyEvent.VK_UP:
                    bu = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = true;
                    break;
                default:
                    break;
            }
            setTankDirection();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bl = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = false;
                    break;
                case KeyEvent.VK_UP:
                    bu = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = false;
                    break;
                default:
                    break;
            }
            setTankDirection();
        }

        private void setTankDirection(){
            if(bl){
                dir = Dir.LEFT;
            }
            if(br){
                dir = Dir.RIGHT;
            }
            if(bu){
                dir = Dir.UP;
            }
            if(bd){
                dir = Dir.DOWN;
            }

        }
    }

    //重写paint方法，当窗口重新绘制的时候调用此方法
    @Override
    public void paint(Graphics g){
        g.fillRect(x,y,50,50);
        switch (dir) {
            case LEFT:
                x-=speed;
                break;
            case RIGHT:
                x+=speed;
                break;
            case UP:
                y-=speed;
                break;
            case DOWN:
                y+=speed;
                break;
        }
    }

}
