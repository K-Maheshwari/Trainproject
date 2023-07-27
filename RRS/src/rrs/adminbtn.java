package rrs;

import java.awt.*;
import javax.swing.*;

public class adminbtn extends JButton {

    Color first, second, third;
    int radius=10;
    public adminbtn() {
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void paintComponent(Graphics g) {
        first = Color.decode("#008000");
        second = Color.decode("#00FF00");

        Graphics2D gr = (Graphics2D) g;
        gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, first, getWidth(), getWidth(), second);
        gr.setPaint(gp);
        gr.fillRoundRect(getX(), getY(), getWidth(), getHeight(), radius, radius);
        super.paintComponent(g);
    }
}
