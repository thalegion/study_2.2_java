import org.omg.CORBA.StringHolder;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by a s u s on 26.02.2017.
 */
class ColorWithName {
    Color color;
    String name;
    public ColorWithName(){
        this.color = new Color(0,0,0);
        this.name = "Black";
    }
    public ColorWithName(int r, int g, int b, String name){
        this.color = new Color(r,g,b);
        this.name = name;
    }
    public ColorWithName(Color color, String name){
        this.color = color;
        this.name = name;
    }

    String getName(){
        return this.name;
    }
    Color getColor(){
        return this.color;
    }
}
class ColorsComboBoxRenderer extends JLabel implements ListCellRenderer {
    public ColorsComboBoxRenderer() {
        setOpaque(true);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
    }

    /*
     * This method finds the image and text corresponding
     * to the selected value and returns the label, set up
     * to display the text and image.
     */
    public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        //Set the icon and text.  If icon was null, say so.
        ColorWithName active = (ColorWithName)value;
        setText(active.getName());
        setFont(list.getFont());

        return this;
    }
}
class ColorsComboBoxModel extends DefaultComboBoxModel<ColorWithName> {
    public ColorsComboBoxModel(ColorWithName[] items) {
        super(items);
    }

    @Override
    public ColorWithName getSelectedItem() {
        ColorWithName selectedColor = (ColorWithName) super.getSelectedItem();

        return selectedColor;
    }
}

public class lab1_11 {

    public static void main (String args[]) {
        JFrame frame = new JFrame("Фут Лаба 1.11");

        //frame init
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600,300);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        ColorWithName[] colors = new ColorWithName[]{
                new ColorWithName(Color.BLACK,"Black"),
                new ColorWithName(Color.RED,"Red"),
                new ColorWithName(Color.PINK,"Pink"),
                new ColorWithName(Color.BLUE,"Blue"),
                new ColorWithName(Color.GREEN,"Green"),
        };
        ColorsComboBoxModel colorsModel = new ColorsComboBoxModel(colors);
        ColorsComboBoxRenderer colorsRender = new ColorsComboBoxRenderer();

        JComboBox colorSelect = new JComboBox(colorsModel);
        colorSelect.setRenderer(colorsRender);
        frame.add(colorSelect,BorderLayout.NORTH);

        JPanel stringHolder = new JPanel();
        frame.add(stringHolder, BorderLayout.CENTER);
        JLabel stringPanel = new JLabel("Строка задания");
        stringHolder.add(stringPanel);


        frame.setVisible(true);

        Timer tm = new Timer(10, new ActionListener(){
            int sDir = 1,
            sX = 0,
            sY = frame.getContentPane().getHeight()/2;
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (sX + stringPanel.getWidth() >= frame.getContentPane().getWidth()) {
                    sDir = -1;
                    stringPanel.setForeground(colorsModel.getSelectedItem().getColor());
                }
                else if (sX <= 0 ) {
                    sDir = 1;
                    stringPanel.setForeground(colorsModel.getSelectedItem().getColor());
                }
                sX += 1*sDir;

                stringPanel.setLocation(sX,sY);
            }});
        tm.start();


    }
}
