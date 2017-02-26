import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

/**
 * Created by a s u s on 26.02.2017.
 */
public class lab1_9 {
    public static void main (String args[]){
        JFrame frame = new JFrame("Фут Лаба 1.9");
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel menu = new JPanel(new FlowLayout());
        frame.add(menu,BorderLayout.NORTH);

        JLabel text1 = new JLabel("Q:");
        menu.add(text1);
        JTextField qField = new JTextField("5");
        qField.setPreferredSize(new Dimension(50,20));
        menu.add(qField);

        JLabel text2 = new JLabel("W:");
        menu.add(text2);
        JTextField wField = new JTextField("5");
        wField.setPreferredSize(new Dimension(50,20));
        menu.add(wField);

        JButton control = new JButton("Старт");
        menu.add(control);

        frame.setVisible(true);

        JPanel canvas = new JPanel();
        canvas.setPreferredSize(new Dimension(frame.getContentPane().getWidth(),frame.getContentPane().getHeight() - menu.getHeight()));
        frame.add(canvas,BorderLayout.SOUTH);

        control.addActionListener(new ActionListener() {
            Timer tm;
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (control.getText() == "Старт") {
                        control.setText("Закончить");

                        tm = new Timer(50, new ActionListener(){
                            int q = Integer.parseInt(qField.getText()),
                                    w = Integer.parseInt(wField.getText()),
                                    t = 0;
                            @Override
                            public void actionPerformed(ActionEvent arg0) {
                                Graphics2D frameGraph = (Graphics2D)canvas.getRootPane().getGraphics();
                                //canvas.update(frameGraph);

                                frameGraph.fillOval(t,canvas.getHeight()/2 +(int)(q*(1 + Math.cos(w * t))/2),5,5);
                                t++;
                            }});
                        tm.start();
                    }
                    else {
                        control.setText("Старт");

                        tm.stop();
                        Graphics2D frameGraph = (Graphics2D)canvas.getRootPane().getGraphics();
                        canvas.update(frameGraph);
                    }
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Введите корректные данные.",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }
}
