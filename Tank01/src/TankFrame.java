import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
/**
 * @author liangshan
 * @ClassName TankFrame
 * @description
 * @date 2021/2/23 15:11
 **/
public class TankFrame extends Frame {

    Tank tank = new Tank(200,400,Dir.DOWN,Group.GOOD,this);
    List<Tank> tanks = new ArrayList<>();
    List<Bullet> bulletList = new ArrayList<>();
    List<Boom> booms = new ArrayList<>();
    protected static final int GAME_WIDTH = 1000,GAME_HEIGHT = 960;

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
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹袋数量：" + bulletList.size(),10,60);
        g.drawString("坦克数量：" + tanks.size(),10,80);
        g.setColor(c);


        tank.paint(g);
        /*bulletList.forEach(e ->{
            e.paint(g);
        });*/
        for (int i = 0; i < bulletList.size(); i++) {
          bulletList.get(i).paint(g);
        }

        for (int i = 0; i < tanks.size(); i++) {
          tanks.get(i).paint(g);
        }
        // 子弹和tank的碰撞检测
        for (int i = 0; i < bulletList.size(); i++ ){
            for (int j = 0; j < tanks.size(); j++) {
                bulletList.get(i).collideWith(tanks.get(j));
            }
        }
    for (int i = 0; i < booms.size(); i++) {
        booms.get(i).paint(g);
    }

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
