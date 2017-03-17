/**
 * Created by arsen on 16.03.2017.
 */
import java.applet.*;
import java.awt.*;
import java.util.Random;


public class lab1_4 extends Applet implements Runnable{
    Thread runner;

    int posXcenter=100;
    int posYcenter=100;
    int posX=0;
    int posY=0;
    float radius=80;
    float time=0;

    Random rand=new Random();





    public void run() {

        while (runner != null) {

            repaint();

            try {

                Thread.sleep( 20 );

            } catch ( InterruptedException e ) {


            }
        }
    }

    public void start() {
        // user visits the page, create a new thread
        if ( runner == null ) {

            runner = new Thread( this );
            runner.start();
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D)g;
        time+=0.1;
        posX=(int)(radius *Math.cos(time));
        posY=(int)(radius *Math.sin(time));
        float _r = rand.nextFloat();
        float _g = rand.nextFloat();
        float _b = rand.nextFloat();

        BasicStroke pen1 = new BasicStroke(10);
        g2D.setStroke(pen1);
        g2D.setColor(new Color(_r,_g,_b));
        g2D.drawLine(posXcenter,posYcenter,posXcenter+posX,posYcenter+posY);

    }
}
