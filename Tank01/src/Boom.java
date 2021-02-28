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

    private int x,y;

    public Boom(int x,int y){
        this.x = x;
        this.y = y;
    }

    private int step = 0;
    public void paint(Graphics g){
        g.drawImage(ResouceMgr.boom[step++],x,y,null);
        if(step == 16){
            step = 0;
        }
    }

}
