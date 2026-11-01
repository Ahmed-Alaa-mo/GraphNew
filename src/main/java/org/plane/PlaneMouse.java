package org.plane;



import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PlaneMouse extends JFrame implements MouseMotionListener {

    private GLCanvas glcanvas;
    private planeEventLinser listener = new planeEventLinser();

    public static void main(String[] args) {
        new PlaneMouse();
    }

    public PlaneMouse() {
        super("Plane Application (Mouse)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addMouseMotionListener(this);

        add(glcanvas, BorderLayout.CENTER);

        setSize(500, 300);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    // convert the mouse pixel position to the scene coordinates (x: -250..250, y: -150..150)
    private double toWorldX(MouseEvent e) {
        return e.getX() * 500.0 / glcanvas.getWidth() - 250;
    }

    private double toWorldY(MouseEvent e) {
        return 150 - e.getY() * 300.0 / glcanvas.getHeight();
    }

    // moving the mouse: left/right moves the plane, up/down changes its size
    @Override
    public void mouseMoved(MouseEvent e) {
        double worldX = toWorldX(e);
        double worldY = toWorldY(e);

        // mouse at the bottom -> scale 0.3, mouse at the top -> scale 3
        double scale = 0.3 + (worldY + 150) / 300 * 2.7;
        listener.scaleXValue = scale;
        listener.scaleYValue = scale;

        // follow the mouse horizontally, but stay inside the screen
        double halfWidth = 50 * scale;
        listener.translateXValue = Math.max(-250 + halfWidth, Math.min(250 - halfWidth, worldX));

        glcanvas.repaint();
    }

    // dragging the mouse (button held): the plane turns to face the mouse
    @Override
    public void mouseDragged(MouseEvent e) {
        double dx = toWorldX(e) - listener.translateXValue;
        double dy = toWorldY(e) - listener.translateYValue;

        listener.rotateAngleValue = Math.toDegrees(Math.atan2(dy, dx));

        glcanvas.repaint();
    }
}
