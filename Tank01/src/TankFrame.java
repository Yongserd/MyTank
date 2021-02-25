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

    Tank tank = new Tank(200,200,Dir.DOWN,this);

    Bullet b = new Bullet(300,300,Dir.DOWN);

    private static final int GAME_WIDTH = 800,GAME_HEIGHT = 600;

    public TankFrame(){
        this.setResizable(true);//可调整大小
        this.setSize(GAME_WIDTH,GAME_HEIGHT );//窗口大小
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
                    //监听ctrl键，发射子弹
                case KeyEvent.VK_CONTROL:
                    tank.fire();
                default:
                    break;
            }
            setTankDirection();
        }

        private void setTankDirection(){
            if(!bd && !bl && !br && !bu){
                tank.setMoving(false);
            }else{
                tank.setMoving(true);
            }
            if(bl){
                tank.setDir(Dir.LEFT);
            }
            if(br){
                tank.setDir(Dir.RIGHT);
            }
            if(bu){
                tank.setDir(Dir.UP);
            }
            if(bd){
                tank.setDir(Dir.DOWN);
            }

        }
    }

    //重写paint方法，当窗口重新绘制的时候调用此方法
    @Override
    public void paint(Graphics g){
        tank.paint(g);
        b.paint(g);
    }

    Image offScreenImage = null;
    //解决画面闪烁问题
    @Override
    public void update(Graphics g) {
        if(offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics graphics = offScreenImage.getGraphics();
        Color c = graphics.getColor();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        graphics.setColor(c);
        paint(graphics);
        g.drawImage(offScreenImage,0,0,null);
    }
}
