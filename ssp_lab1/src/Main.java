import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.Border;

public class Main {
    public static ImageIcon createThumb(String srcImage, int w, int h) {
        ImageIcon imageIcon = new ImageIcon(srcImage);
        Image image = imageIcon.getImage();
        Image rszImage = image.getScaledInstance(w,h, Image.SCALE_SMOOTH);

        return new ImageIcon(rszImage);
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

        JFrame fr=new JFrame("Фут Лаба 1");
        fr.setPreferredSize( new Dimension(workspaceWidth,workspaceHeight));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Point leftTopCorner = new Point(screenSize.width/2 - workspaceWidth/2, screenSize.height/2 - workspaceHeight/2);
        fr.setLocation(leftTopCorner);

        final JPanel pan= new JPanel(new BorderLayout());
        fr.add(pan);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //add planet image to panel
        ImageIcon earthImage = Main.createThumb(earthImagePath,earthImageWidth,earthImageHeight);
        JLabel earthLabel = new JLabel("",earthImage,JLabel.CENTER);
        pan.add(earthLabel,BorderLayout.CENTER);

        ImageIcon moonImage = Main.createThumb(moonImagePath,moonImageWidth,moonImageHeight);
        JLabel moonLabel = new JLabel("",moonImage,JLabel.CENTER);
        pan.add(moonLabel, BorderLayout.EAST);

        fr.pack();

        Timer tm = new Timer(5, new ActionListener(){
            int minX = 180,
                minY = 0,
                r = 200;

            double i = 0.01;
            @Override
            public void actionPerformed(ActionEvent arg0) {

                moonLabel.setLocation((int)(minX + r*Math.cos(i)/1.5),(int)(minY + r*Math.sin(i)));

                i += 0.01;
                if (i % 2 == 0)
                    System.out.println("mod 2");
                else if (i % 1 == 0 || i % 3 == 0 )
                    System.out.println("mod 1\3");
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
