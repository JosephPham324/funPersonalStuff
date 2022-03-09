package pkg83;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;

/**
 *
 * @author Pham Nhat Quang
 */
public class MyPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 1560;
    final int PANEL_HEIGHT = 850;
    Image flower[];
    Image backGroundImage;
    Image Wishes;
    Timer timer;
    int count;
    int xVelocity[];
    int yVelocity[];
    int x[];
    int y[];

    public MyPanel(String[] flower) {
        x = new int[4];
        y = new int[4];
        xVelocity = new int[4];
        yVelocity = new int[4];
        Arrays.fill(xVelocity, 20);
        Arrays.fill(yVelocity, 20);
        Arrays.fill(x, 0);
        Arrays.fill(y, 0);
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.GREEN);
        this.flower = new Image[4];
        this.backGroundImage = new ImageIcon("src/169004.jpg").getImage();
        for (int i = 0; i < flower.length; i++) {
            this.flower[i] = new ImageIcon(flower[i]).getImage();
            if (i % 2 == 0) {
                this.x[i] += 180 * i;
                this.y[i] += 120;
            } else if (i % 3 != 0) {
                this.x[i] += 180 * i;
                this.y[i] += 0;
            }
            if (i == 3) {
                this.x[i] += 180;
                this.y[i] += 120 * 2;
            }
        }
        this.Wishes = new ImageIcon("src/Wishes.png").getImage();
        timer = new Timer(1, this);
        timer.start();
        count = 0;
    }

    public void paint(Graphics g) {

        super.paint(g); //Paint background
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(backGroundImage, 0, 0, null);
        for (int i = 0; i < flower.length; i++) {
            g2D.drawImage(flower[i], x[i], y[i], null);
        }
//        if (count >= 13) {
//            g2D.drawImage(Wishes, 450, 100, null);
//        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int impactx = 0;
        int impacty = 0;

        if (count == 12) {
            xVelocity[0] *= -1;
            yVelocity[0] *= -1;

            xVelocity[1] *= 1;
            yVelocity[1] *= 1;

            xVelocity[2] *= -1;
            yVelocity[2] *= 1;

            xVelocity[3] *= 1;
            yVelocity[3] *= -1;
            count++;
            for (int i = 0; i < 4; i++) {
                int directionx = impactx - x[i];
                int directiony = impacty - y[i];
                if (directionx > 0) {
                    if (xVelocity[i] < 0) {
                        xVelocity[i] *= -1;
                    }
                } else if (directionx < 0) {
                    if (xVelocity[i] > 0) {
                        xVelocity[i] *= -1;
                    }
                }
                if (directiony > 0) {
                    if (yVelocity[i] < 0) {
                        yVelocity[i] *= -1;
                    }
                } else if (directiony < 0) {
                    if (yVelocity[i] > 0) {
                        yVelocity[i] *= -1;
                    }
                }
            }
        }
        if (count < 12) {
            for (int i = 0; i < 4; i++) {
                if (x[i] >= PANEL_WIDTH - 200 || x[i] < 0) {
                    for (int j = 0; j < 4; j++) {
                        xVelocity[j] *= -1;
                    }
                    impactx = x[i];
                    count++;
                    break;
                }
            }
            for (int i = 0; i < 4; i++) {
                if (y[i] >= PANEL_HEIGHT - 200 || y[i] < 0) {
                    for (int j = 0; j < 4; j++) {
                        yVelocity[j] *= -1;
                    }
                    impacty = y[i];
                    count++;
                    break;
                }
            }

        } else {
            for (int i = 0; i < 4; i++) {
                if (x[i] >= PANEL_WIDTH - flower[i].getWidth(null) || x[i] < 0) {
                    xVelocity[i] *= -1;
                    count++;
                }
            }
            for (int i = 0; i < 4; i++) {
                if (y[i] >= PANEL_HEIGHT - flower[i].getHeight(null) || y[i] < 0) {
                    yVelocity[i] *= -1;
                    count++;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            x[i] = x[i] + xVelocity[i];
            y[i] = y[i] + yVelocity[i];
        }
        repaint();
    }
}
