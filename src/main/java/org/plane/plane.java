
package org.plane;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class plane extends JFrame implements KeyListener {

    private GLCanvas glcanvas;
    private planeEventLinser listener = new planeEventLinser();

    public static void main(String[] args) {
        new plane();
    }

    public plane() {
        super("Plane Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addKeyListener(this);

        add(glcanvas, BorderLayout.CENTER);

        setSize(500, 300);
        setLocationRelativeTo(this);
        setVisible(true);

        // give keyboard focus to the canvas so the keys work immediately
        glcanvas.requestFocus();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // move left / right
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            listener.translateXValue -= 5;
        } else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            listener.translateXValue += 5;
        }
        // scale up / down
        else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            listener.scaleXValue += 0.1;
            listener.scaleYValue += 0.1;
        } else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            listener.scaleXValue -= 0.1;
            listener.scaleYValue -= 0.1;
        }
        // rotate
        else if (key == KeyEvent.VK_Q) {
            listener.rotateAngleValue += 5;
        } else if (key == KeyEvent.VK_E) {
            listener.rotateAngleValue -= 5;
        }

        // scale limits
        if (listener.scaleXValue < 0.3) listener.scaleXValue = 0.3;
        if (listener.scaleXValue > 3)   listener.scaleXValue = 3;
        if (listener.scaleYValue < 0.3) listener.scaleYValue = 0.3;
        if (listener.scaleYValue > 3)   listener.scaleYValue = 3;

        // position limits (the plane sticks out 50 units on each side of its center)
        double halfWidth = 50 * listener.scaleXValue;
        if (listener.translateXValue < -250 + halfWidth) listener.translateXValue = -250 + halfWidth;
        if (listener.translateXValue > 250 - halfWidth)  listener.translateXValue = 250 - halfWidth;

        // keep the angle between 0 and 360
        listener.rotateAngleValue %= 360;

        glcanvas.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
 