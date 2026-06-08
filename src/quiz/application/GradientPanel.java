package quiz.application;
import java.awt.*;
import javax.swing.*;

public class GradientPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                            RenderingHints.VALUE_RENDER_QUALITY);

        int w = getWidth();
        int h = getHeight();

        Color top = new Color(91,46,255);
        Color mid = new Color(123,63,242);
        Color bot = new Color(30,136,229);

        GradientPaint gp1 = new GradientPaint(0,0,top,0,h/2,mid);
        g2.setPaint(gp1);
        g2.fillRect(0,0,w,h/2);

        GradientPaint gp2 = new GradientPaint(0,h/2,mid,0,h,bot);
        g2.setPaint(gp2);
        g2.fillRect(0,h/2,w,h/2);
    }
}