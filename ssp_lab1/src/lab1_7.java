import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.util.logging.ConsoleHandler;

/**
 * Created by a s u s on 26.02.2017.
 */
public class lab1_7 {

    public static void main (String args[]){
        JFrame frame = new JFrame("Фут лаба 1.7");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel menu = new JPanel(new GridLayout());
        frame.add(menu,BorderLayout.NORTH);

        JLabel text1 = new JLabel("Толщина линии:");
        menu.add(text1);
        JTextField lineWidthField = new JTextField("22");
        menu.add(lineWidthField);

        JLabel text2 = new JLabel("R:");
        menu.add(text2);
        JTextField redField = new JTextField("0");
        menu.add(redField);
        JLabel text3 = new JLabel("G:");
        menu.add(text3);
        JTextField greenField = new JTextField("0");
        menu.add(greenField);
        JLabel text4 = new JLabel("B:");
        menu.add(text4);
        JTextField blueField = new JTextField("0");
        menu.add(blueField);


        frame.setVisible(true);

        JPanel canvas = new JPanel();
        canvas.setPreferredSize(new Dimension(frame.getContentPane().getWidth(),frame.getContentPane().getHeight() - menu.getHeight()));
        frame.add(canvas,BorderLayout.SOUTH);
        canvas.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

        canvas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                try {
                    if (canvas.contains(e.getX(),e.getY() - 20)) {
                        Graphics2D frameGraph = (Graphics2D)canvas.getRootPane().getGraphics();

                        frameGraph.setColor(
                                new Color(
                                        Integer.parseInt(redField.getText()),
                                        Integer.parseInt(greenField.getText()),
                                        Integer.parseInt(blueField.getText())
                                )
                        );
                        frameGraph.setStroke(
                                new BasicStroke(
                                        Float.parseFloat(lineWidthField.getText()),
                                        BasicStroke.CAP_ROUND,
                                        BasicStroke.JOIN_ROUND
                                )
                        );
                        frameGraph.draw(
                                new Line2D.Float(
                                        (float)e.getX(),
                                        (float)e.getY() + 20,
                                        (float)e.getX(),
                                        (float)e.getY() + 20
                                )
                        );
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Введите корректные данные для кисти.",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        /*
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                drawEnable[0] = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                drawEnable[0] = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });*/

    }
}
