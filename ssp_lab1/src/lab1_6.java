import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
public class lab1_6 {
    public static void main(String[] args) {
        JFrame fr=new JFrame("Фут Лаба 1.6");
        fr.setPreferredSize( new Dimension(300,300));
        final JPanel pan= new JPanel();
        fr.add(pan);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        Timer tm= new Timer(50, new ActionListener(){
            int i=0;
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Graphics2D gr=(Graphics2D)pan.getRootPane().getGraphics();
                pan.update(gr);
                GeneralPath path=new GeneralPath();
                path.append(new Polygon(new int []{10,100,100,10},new int[]{-10,-10,-100,-100},4),true);
                int x=(10+100+100+10)/4,y=(-10-10-100-100)/4;
                gr.translate(150, 150);
                AffineTransform tranforms = AffineTransform.getRotateInstance((i++)*0.07, x, y);
                gr.transform(tranforms);
                gr.draw(path);
            }});
        tm.start();
    }
}
