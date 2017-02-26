import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class lab1_12 {
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

        JFrame fr = new JFrame("Фут Лаба 1.12");
        fr.setPreferredSize(new Dimension(workspaceWidth,workspaceHeight));
        fr.setResizable(false);

        final JPanel pan = new JPanel(new BorderLayout());
        fr.add(pan);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //add planet image to panel
        ImageIcon earthImage = new ImageIcon(lab1_12.createThumb(earthImagePath,earthImageWidth,earthImageHeight));
        JLabel earthLabel = new JLabel("",earthImage,JLabel.CENTER);
        pan.add(earthLabel,BorderLayout.CENTER);

        ImageIcon moonImage = new ImageIcon(lab1_12.createThumb(moonImagePath,moonImageWidth,moonImageHeight));
        JLabel moonLabel = new JLabel("",moonImage,JLabel.CENTER);
        moonLabel.setPreferredSize(new Dimension(200,200));
        pan.add(moonLabel, BorderLayout.EAST);

        fr.pack();
        earthLabel.setLocation(90,0);

        Timer tm = new Timer(10, new ActionListener(){
            int minX = 180,
                minY = 0,
                r = 200;

            float i = 0.00f;
            @Override
            public void actionPerformed(ActionEvent arg0) {

                moonLabel.setLocation((int)(minX + r*Math.cos(i)),(int)(minY + r*Math.sin(i)/1.5));

                i += 0.01f;
                i = (float)Math.round(i * 100)/100;
                if (i % 0.28 > 0 && i % 0.28 < 0.1) {
                    if (i % 6.28 > 4.71 || i % 6.28 < 1.57)
                        moonImage.setImage(lab1_12.createThumb(moonImagePath,moonImage.getIconWidth() + 1,moonImage.getIconHeight() + 1));
                    else
                        moonImage.setImage(lab1_12.createThumb(moonImagePath,moonImage.getIconWidth() - 1,moonImage.getIconHeight() - 1));
                }
                if (i % 6.28 > 0.1 && i % 6.28 < 0.2) {
                    pan.removeAll();
                    pan.add(moonLabel, BorderLayout.EAST);
                    pan.add(earthLabel, BorderLayout.CENTER);
                } else if (i % 6.28 > 3.1 && i % 6.28 < 3.2) {
                    pan.add(earthLabel,BorderLayout.CENTER);
                    pan.add(moonLabel,BorderLayout.EAST);
                }
            }});
        tm.start();
    }
}
