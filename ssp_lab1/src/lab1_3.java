import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

/**
 * Created by a s u s on 26.02.2017.
 */

public class lab1_3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Фут Лаба 1.3");
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        Timer tm = new Timer(50, new ActionListener(){
            double scaleVal = 0.01,
            step = 0.01;
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Graphics2D ball = (Graphics2D)frame.getRootPane().getGraphics();
                frame.update(ball);

                if (scaleVal == 0.01)
                    step = 0.01;
                else if (scaleVal == 1)
                    step = -0.01;

                scaleVal += step;
                scaleVal = (double)Math.round(scaleVal * 100)/100;
                GeneralPath ballPath = new GeneralPath();
                ballPath.append(new Ellipse2D.Float(
                        frame.getWidth()/2 - (200*(float)scaleVal)/2,
                        frame.getHeight()/2 - (200*(float)scaleVal)/2,
                        200*(float)scaleVal,
                        200*(float)scaleVal), true);
                ball.draw(ballPath);
            }});
        tm.start();
    }
}
