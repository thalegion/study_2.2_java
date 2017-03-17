import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class lab1_10 {

    public static int direction = 0;
    public static String fontName = "";

    public static void main(String... args) {
        JFrame frame = new JFrame("Absolute Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);

        JLabel label = new JLabel("This JPanel uses Absolute Positioning", JLabel.CENTER);
        label.setSize(300, 30);
        label.setLocation(0, 30);

        String[] fontsArray = {"Time New Romance", "Courier New"};
        JComboBox fonts = new JComboBox(fontsArray);
        fonts.setSize(500, 30);
        fonts.setSelectedIndex(0);
        fontName = fonts.getItemAt(0).toString();
        fonts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                fontName = (String) cb.getSelectedItem();
            }
        });

        contentPane.add(label);
        contentPane.add(fonts);

        frame.setContentPane(contentPane);
        frame.setSize(500, 500);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Timer timer = new Timer(50, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LabelMovie(label);
                    }
                });
                timer.start();
            }
        });
    }

    public static void LabelMovie(JLabel label) {
        int widthPane = label.getParent().getWidth();
        int heightPane = label.getParent().getHeight();
        int widthLabel = label.getWidth();
        int heightLbel = label.getHeight();
        int x = label.getX();
        int y = label.getY();
        int x_right = x + widthLabel;
        int y_bottom = y + heightLbel;
        String text = label.getText();

        if (x_right == widthPane || y_bottom == heightPane) {
            direction = 1;
            text = changeReg(text);
        } else if (x == 0 || y == 10) {
            text = changeReg(text);
            direction = 0;
        }
        label.setText(text);
        label.setFont(new Font(fontName, Font.PLAIN, 14));

        if (direction == 0) {
            label.setLocation(x + 1, y + 1);
        } else {
            label.setLocation(x - 1, y - 1);
        }
    }

    private static String changeReg(String text) {
        int length = text.length();
        Random random = new Random();
        String new_text = "";

        for (int i = 0; i < length; i++) {
            char el = text.charAt(i);
            boolean uppeercase = random.nextBoolean();
            if (uppeercase) {
                new_text += Character.toString(el).toUpperCase();
            } else {
                new_text += Character.toString(el).toLowerCase();
            }
        }
        return new_text;
    }
}