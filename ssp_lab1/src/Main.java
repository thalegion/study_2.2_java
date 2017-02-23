import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.Border;

public class Main {
    public static Image createThumb(String srcImage, int w, int h) {
        ImageIcon imageIcon = new ImageIcon(srcImage);
        Image image = imageIcon.getImage();
        Image rszImage = image.getScaledInstance(w,h, Image.SCALE_SMOOTH);

        return rszImage;
    }

    public static void main(String[] args) {
        int workspaceWidth = 600,
            workspaceHeight = 600,
            earthImageWidth = 250,
            earthImageHeight = 250,
            moonImageWidth = 100,
            moonImageHeight = 100;
        String earthImagePath = "out/production/ssp_lab1/images/earth.png",
                moonImagePath = "out/production/ssp_lab1/images/MOON.PNG";

        JFrame fr = new JFrame("Фут Лаба 1");
        fr.setSize(workspaceWidth,workspaceHeight);
        fr.setLocationRelativeTo(null);

        final JPanel pan = new JPanel(new BorderLayout());
        fr.add(pan);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //add planet image to panel
        ImageIcon earthImage = new ImageIcon(Main.createThumb(earthImagePath,earthImageWidth,earthImageHeight));
        JLabel earthLabel = new JLabel("",earthImage,JLabel.CENTER);
        pan.add(earthLabel,BorderLayout.CENTER);

        ImageIcon moonImage = new ImageIcon(Main.createThumb(moonImagePath,moonImageWidth,moonImageHeight));
        JLabel moonLabel = new JLabel("",moonImage,JLabel.CENTER);
        moonLabel.setPreferredSize(new Dimension(200,200));
        pan.add(moonLabel, BorderLayout.EAST);

        fr.pack();
        earthLabel.setLocation(90,0);

        Timer tm = new Timer(10, new ActionListener(){
            int minX = 180,
                minY = 0,
                r = 200;

            float i = 0.01f;
            @Override
            public void actionPerformed(ActionEvent arg0) {

                moonLabel.setLocation((int)(minX + r*Math.cos(i)),(int)(minY + r*Math.sin(i)/1.5));

                i += 0.01f;
                if (i % 0.2 > 0 && i % 0.2 < 0.1) {
                    if (i % 6.28 > 4.71 || i % 6.28 < 1.57)
                        moonImage.setImage(Main.createThumb(moonImagePath,moonImage.getIconWidth() + 1,moonImage.getIconHeight() + 1));
                    else
                        moonImage.setImage(Main.createThumb(moonImagePath,moonImage.getIconWidth() - 1,moonImage.getIconHeight() - 1));
                }
                if (i % 6.28 > 0.1 && i % 6.28 < 0.2) {
                    pan.removeAll();
                    pan.add(moonLabel, BorderLayout.EAST);
                    pan.add(earthLabel, BorderLayout.CENTER);
                } else if (i % 6.28 > 3.1 && i % 6.28 < 3.2) {
                    pan.add(earthLabel,BorderLayout.CENTER);
                    pan.add(moonLabel,BorderLayout.EAST);
                }
                /*
                Graphics2D gr = (Graphics2D)pan.getRootPane().getGraphics();
                pan.update(gr);
                GeneralPath path = new GeneralPath();
                path.append(new Polygon(new int []{60,-80,50},new int[]{-60,-50,40},3),true);
                int x=(60-80+50)/3,y=(-60-50+40)/3;
                gr.translate(150, 150);
                AffineTransform tranforms = AffineTransform.getRotateInstance((i++)*0.07, x, y);
                gr.transform(tranforms);
                gr.draw(path);*/
            }});
        tm.start();
    }
}
