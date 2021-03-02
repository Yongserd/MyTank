import java.awt.*;

/**
 * @author liangshan
 * @ClassName Boom
 * @description
 * @date 2021/2/28 23:43
 **/
public class Boom {
    public static final int WIDTH = ResouceMgr.boom[0].getWidth();
    public static final int HEIGHT = ResouceMgr.boom[0].getHeight();
    private  TankFrame tankFrame;
    private int x,y;

    public Boom(int x,int y,TankFrame tankFrame){
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

    private int step = 0;
    public void paint(Graphics g){
        g.drawImage(ResouceMgr.boom[step++],x,y,null);
        if(step == 16){
            step = 0;
            //移除boom
            tankFrame.booms.remove(this);
        }
    }

}
