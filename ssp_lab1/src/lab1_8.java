import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

/**
 * Created by User on 14.03.2017.
 */
class SpeedController{
    int speed;

    SpeedController(){
        this.speed = 1;
    }

    int getSpeed(){
        return this.speed;
    }
    void incSpeed() {
        if (this.speed > 30) {
            JOptionPane.showMessageDialog(
                    null,
                    "Скорость не возможно больше увеличить.",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE
            );
        } else
            this.speed++;
    }

    void decSpeed() {
        if (this.speed < 1) {
            JOptionPane.showMessageDialog(
                    null,
                    "Скорость не возможно больше уменьшить.",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE
            );
        } else
            this.speed--;
    }
}

public class lab1_8 {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Фут Лаба 1.8");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        SpeedController speedControl = new SpeedController();
        JPanel buttonHolder = new JPanel();
        frame.add(buttonHolder,BorderLayout.NORTH);

        JButton plusButton = new JButton("+");
        buttonHolder.add(plusButton);
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speedControl.incSpeed();
            }
        });

        JButton minusButton = new JButton("-");
        buttonHolder.add(minusButton);
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speedControl.decSpeed();
            }
        });

        JPanel actionPanel = new JPanel();
        frame.add(actionPanel,BorderLayout.CENTER);

        frame.setVisible(true);
        Timer tm = new Timer(50, new ActionListener(){
            int position = 10,
                dir = 1;
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Graphics2D ball = (Graphics2D)actionPanel.getGraphics();
                actionPanel.update(ball);

                if (position + 10 >= actionPanel.getWidth())
                    dir = -1;
                else if (position <= 0)
                    dir = 1;

                position += speedControl.getSpeed()*dir;

                GeneralPath ballPath = new GeneralPath();
                ballPath.append(new Ellipse2D.Float(
                        position,
                        0,
                        10,
                        10), false);
                ball.draw(ballPath);
            }});
        tm.start();
    }
}
