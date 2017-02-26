import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;

/**
 * Created by a s u s on 26.02.2017.
 */
public class lab1_5 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Фут Лаба 1.5");
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        Timer tm = new Timer(50, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Graphics2D graphic = (Graphics2D)frame.getRootPane().getGraphics();
                frame.update(graphic);

                GeneralPath pointPath = new GeneralPath();
                pointPath.append(new Ellipse2D.Double(
                        frame.getContentPane().getWidth()*0.25,
                        frame.getContentPane().getHeight()/2 - 5,
                        10,
                        10
                ),true);

                graphic.setPaint(Color.blue);
                graphic.fill(pointPath);

                AffineTransform rotation = new AffineTransform();
                rotation.rotate(0.1);
                GeneralPath linePath = new GeneralPath();
                linePath.append(new Line2D.Double(
                        frame.getContentPane().getWidth()*0.25,
                        frame.getContentPane().getHeight()/2,
                        frame.getContentPane().getWidth() * 0.75 ,
                        frame.getContentPane().getHeight()/2),true);
                graphic.transform(rotation);
                graphic.setPaint(Color.BLACK);
                graphic.draw(linePath);

            }});
        tm.start();
    }
}
