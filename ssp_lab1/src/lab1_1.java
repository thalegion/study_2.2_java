import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by a s u s on 26.02.2017.
 */
/*
class JLabelStorage {
    JLabel label;
    int xDirection,
        yDirection;

    JLabelStorage() {
        this.label = new JLabel();
        this.xDirection = this.yDirection = 1;
    }
    JLabelStorage(String title) {
        this.label = new JLabel(title);
        this.xDirection = this.yDirection = 1;
    }
    JLabelStorage(String title, int xDirection, int yDirection) {
        this.label = new JLabel(title);
        this.xDirection = xDirection;
        this.yDirection = yDirection;
    }

    JLabel getLabel() {
        return  this.label;
    }
    int getXDirection(){
        return  this.xDirection;
    }
    int getYDirection(){
        return  this.yDirection;
    }
    void setXDirection(int x){
        this.xDirection = x;
    }
    void setYDirection(int y){
        this.yDirection = y;
    }
}

public class lab1_1 {

    public static void main(String args[]){
        JFrame frame = new JFrame("Фут Лаба 1.1");
        Random randomer = new Random();

        //frame init
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(600,600);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);


        //Strings & labels init
        int sArrayLength = randomer.nextInt(15) + 5;
        JLabelStorage[] labels = new JLabelStorage[sArrayLength];

        for (int i = 0; i < sArrayLength; i++) {

            int curStringLength = randomer.nextInt(10) + 3;
            String curString = "";
            for (int j = 0; j < curStringLength; j++) {
                int charCode = randomer.nextInt(122) + 33;
                curString += Character.toString((char) charCode);
            }


            int curXDirection = randomer.nextInt(10) % 2 == 0 ? -1 : 1,
                curYDirection = randomer.nextInt(10) % 2 == 0 ? -1 : 1;
            labels[i] = new JLabelStorage(curString,curXDirection,curYDirection);
            frame.add(labels[i].getLabel());
        }


        Timer tm = new Timer(10, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                for (int i = 0; i < labels.length; i ++) {
                    JLabel curLabel = labels[i].getLabel();
                    int curX = curLabel.getX(),
                        curY = curLabel.getY(),
                        dirX = labels[i].getXDirection(),
                        dirY = labels[i].getYDirection();

                    if (curX <= 0) {
                        dirX = 1;
                        labels[i].setXDirection(dirX);
                    } else if ((curX + curLabel.getWidth()) >= frame.getWidth()) {
                        dirX = -1;
                        labels[i].setXDirection(dirX);
                    }
                    if (curY <= 0) {
                        dirY = 1;
                        labels[i].setYDirection(dirY);
                    } else if ((curY + curLabel.getHeight()*2) >= frame.getHeight()) {
                        dirY = -1;
                        labels[i].setYDirection(dirY);
                    }

                    curX += 1*dirX;
                    curY += 1*dirY;

                    curLabel.setLocation(curX,curY);
                }
            }});
        tm.start();

    }
}
*/

class JLabelStorage {
    JLabel label;
    int direction;

    JLabelStorage() {
        this.label = new JLabel();
        this.direction = 0;
    }
    JLabelStorage(String title) {
        this.label = new JLabel(title);
        this.direction = 0;
    }
    JLabelStorage(String title, int direction) {
        this.label = new JLabel(title);
        this.direction = direction;
    }

    JLabel getLabel() {
        return  this.label;
    }
    int getDirection(){
        return  this.direction;
    }
    void setDirection(int direction){
        this.direction = direction;
    }
}

public class lab1_1 {

    public static void main(String args[]){
        JFrame frame = new JFrame("Фут Лаба 1.1");
        Random randomer = new Random();

        //frame init
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(600,300);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);


        //Strings & labels init
        int sArrayLength = randomer.nextInt(15) + 5;
        JLabelStorage[] labels = new JLabelStorage[sArrayLength];

        for (int i = 0; i < sArrayLength; i++) {

            int curStringLength = randomer.nextInt(10) + 3;
            String curString = "";
            for (int j = 0; j < curStringLength; j++) {
                int charCode = randomer.nextInt(122) + 33;
                curString += Character.toString((char) charCode);
            }


            int curDirection = randomer.nextInt(7);
            labels[i] = new JLabelStorage(curString,curDirection);
            frame.add(labels[i].getLabel());
        }


        Timer tm = new Timer(10, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                for (int i = 0; i < labels.length; i ++) {
                    JLabel curLabel = labels[i].getLabel();
                    int curX = curLabel.getX(),
                            curY = curLabel.getY(),
                            dir = labels[i].getDirection();
                    boolean moved = false,
                            dirChanged = false;

                    while (!moved) {
                        switch (dir) {
                            case 0:
                                if (curY <= 0) {
                                    dir = randomer.nextInt(7);
                                    dirChanged = true;
                                }
                                else {
                                    curY -= 1;
                                    moved = true;
                                }
                                    break;
                            case 1:
                                if (curY <= 0 || (curX + curLabel.getWidth()) >= frame.getContentPane().getWidth()){
                                    dir = randomer.nextInt(7);
                                    dirChanged = true;
                                }
                                else {
                                    curY -= 1;
                                    curX += 1;
                                    moved = true;
                                }
                                break;
                            case 2:
                                if ((curX + curLabel.getWidth()) >= frame.getContentPane().getWidth()){
                                    dir = randomer.nextInt(7);
                                    dirChanged = true;
                                }
                                else {
                                    curX += 1;
                                    moved = true;
                                }
                                break;
                            case 3:
                                if ((curY + curLabel.getHeight()) >= frame.getContentPane().getHeight() || (curX + curLabel.getWidth()) >= frame.getContentPane().getWidth()){
                                    dir = randomer.nextInt(7);
                                    dirChanged = true;
                                }
                                else {
                                    curY += 1;
                                    curX += 1;
                                    moved = true;
                                }
                                break;
                            case 4:
                                if ((curY + curLabel.getHeight()) >= frame.getContentPane().getHeight()){
                                    dir = randomer.nextInt(7);
                                    dirChanged = true;
                                }
                                else {
                                    curY += 1;
                                    moved = true;
                                }
                                break;
                            case 5:
                                if ((curY + curLabel.getHeight()) >= frame.getContentPane().getHeight() || curX <= 0){
                                    dir = randomer.nextInt(7);
                                    dirChanged = true;
                                }
                                else {
                                    curY += 1;
                                    curX -= 1;
                                    moved = true;
                                }
                                break;
                            case 6:
                                if (curX <= 0){
                                    dir = randomer.nextInt(7);
                                    dirChanged = true;
                                }
                                else {
                                    curX -= 1;
                                    moved = true;
                                }
                                break;
                            case 7:
                                if (curY <= 0 || curX <= 0){
                                    dir = randomer.nextInt(7);
                                    dirChanged = true;
                                }
                                else {
                                    curY -= 1;
                                    curX -= 1;
                                    moved = true;
                                }
                                break;
                        }
                    }
                    if (dirChanged)
                        labels[i].setDirection(dir);
                    curLabel.setLocation(curX,curY);
                }
            }});
        tm.start();

    }
}