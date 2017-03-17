import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
public class lab1_5 {

    public static void main(String[] args) {

        JFrame fr=new JFrame("Изобразить в окне приложения отрезок, вращающийся в плоскости фрейма вокруг точки, движущейся по отрезку");
        fr.setPreferredSize( new Dimension(600,120));
        final JPanel pan= new JPanel();
        fr.add(pan);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();



        Timer tm= new Timer(100, new ActionListener(){
            int i=0;
            int q=0;
            int z = 1;

            @Override

            public void actionPerformed(ActionEvent arg0) {
                int start=50; int end=550;//start and end of line
                int ls=50; int le=80;


                Graphics2D gr = (Graphics2D) pan.getRootPane().getGraphics();
                pan.update(gr);
                gr.setColor(Color.RED);
                gr.draw(new Line2D.Double(start, start, end, start));
                gr.setColor(Color.black);
                GeneralPath path = new GeneralPath();

                ls=ls+i;
                le=le+i;

                path.append(new Line2D.Double(ls, 50, le, 80), true);
                int x = ls, y = 50;
                AffineTransform tranforms = AffineTransform.getRotateInstance((i) * 0.07, x, y);

                if (ls==end){z = 0;} else if(ls==start){z = 1;}
                if(z == 1){i++;}else{i--;}
                gr.transform(tranforms);
                gr.draw(path);

            }
        });

        tm.start();

    }

}
