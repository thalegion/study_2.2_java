import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class lab1_2 {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Лаба 1 Волчецкий");
        mainFrame.setPreferredSize(new Dimension(500, 500));

        final JPanel mainPanel = new JPanel();
        mainFrame.add(mainPanel);

        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();

        Timer mainTimer = new Timer(17, new ActionListener() {

            int ellipseRadius = 60,
                    ellipsePosX = 0, //windowWidth/2 - ellipseRadius,
                    ellipsePosY = 0,
                    posXDirection = 5,
                    posYDirection = 5,
                    ellipseWidth = ellipseRadius*2,
                    ellipseHeight = ellipseRadius*2,
                    compressDirectionX = 5,
                    compressDirectionY = 5;

            boolean wasCompressedX = false,
                    wasCompressedY = false,
                    stopMoveX = false,
                    stopMoveY = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                Graphics2D graphicsObject = (Graphics2D) mainPanel.getRootPane().getGraphics();

                mainPanel.update(graphicsObject);

                GeneralPath ellipsePath = new GeneralPath();

                if (((ellipsePosX + ellipseWidth) >= mainPanel.getWidth() && posXDirection > 0) || (ellipsePosX <= 0 && posXDirection < 0)) {
                    if (wasCompressedX) {
                        stopMoveY = false;
                        wasCompressedX = false;
                        posXDirection *= -1;
                        compressDirectionX *= -1;
                    } else {
                        stopMoveY = true;
                        if ((ellipsePosX + ellipseWidth) >= mainPanel.getWidth()) {
                            ellipseWidth -= compressDirectionX;
                            if (ellipseWidth > ellipseRadius*2/5*4) {
                                ellipsePosX += compressDirectionX;
                            } else {
                                compressDirectionX *= -1;
                            }
                        } else if(ellipsePosX <= 0) {
                            ellipseWidth -= compressDirectionX;
                            if (ellipseWidth <= ellipseRadius*2/5*4) {
                                compressDirectionX *= -1;
                            }
                        }


                        if (ellipseWidth == ellipseRadius * 2) {
                            wasCompressedX = true;
                        }
                    }
                } else {
                    if (!stopMoveX) {
                        ellipsePosX += posXDirection;
                    }
                }

                if (((ellipsePosY + ellipseHeight) >= mainPanel.getHeight() && posYDirection > 0) || (ellipsePosY <= 0 && posYDirection < 0)) {
                    if (wasCompressedY) {
                        stopMoveX = false;
                        wasCompressedY = false;
                        posYDirection *= -1;
                        compressDirectionY *= -1;
                    } else {
                        stopMoveX = true;
                        if ((ellipsePosY + ellipseHeight) >= mainPanel.getHeight()) {
                            ellipseHeight -= compressDirectionY;
                            if (ellipseHeight > ellipseRadius*2/5*4) {
                                ellipsePosY += compressDirectionY;
                            } else {
                                compressDirectionY *= -1;
                            }
                        } else if(ellipsePosY <= 0) {
                            ellipseHeight -= compressDirectionY;
                            if (ellipseHeight <= ellipseRadius*2/5*4) {
                                compressDirectionY *= -1;
                            }
                        }


                        if (ellipseHeight == ellipseRadius * 2) {
                            wasCompressedY = true;
                        }
                    }
                } else {
                    if (!stopMoveY) {
                        ellipsePosY += posYDirection;
                    }
                }

                ellipsePath.append((new Ellipse2D.Float(0, 0, ellipseWidth, ellipseHeight)), true);

                graphicsObject.translate(ellipsePosX, ellipsePosY);
                graphicsObject.draw(ellipsePath);
            }});

        mainTimer.start();
    }
}
