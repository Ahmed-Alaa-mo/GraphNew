package org.plane;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class planeEventLinser implements GLEventListener {

    final double ONE_DEGREE = (Math.PI / 180);
    final double THREE_SIXTY = 2 * Math.PI;

    public double scaleXValue = 1;
    public double scaleYValue = 1;
    public double translateXValue = 0;
    public double translateYValue = 0;
    public double rotateAngleValue = 0;

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();

        gl.glOrtho(-250.0, 250.0, -150.0, 150.0, -1, 1);
    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();

        drawGraph(gl);
        drawPlane(gl);
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }

    private void drawGraph(GL gl) {
        float red;
        float green;
        float blue;
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        // the grid
        red = 0.2f;
        green = 0.2f;
        blue = 0.2f;
        gl.glColor3f(red, green, blue);
        gl.glBegin(GL.GL_LINES);
        for (int x = -250; x <= 250; x += 10) {
            gl.glVertex2d(x, -150);
            gl.glVertex2d(x, 150);
        }
        for (int y = -150; y <= 150; y += 10) {
            gl.glVertex2d(-250, y);
            gl.glVertex2d(250, y);
        }
        gl.glEnd();

        // the x-axis and y-axis
        red = 0.0f;
        green = 0.2f;
        blue = 0.4f;
        gl.glColor3f(red, green, blue);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2d(0, 140);
        gl.glVertex2d(0, -140);
        gl.glVertex2d(240, 0);
        gl.glVertex2d(-240, 0);
        gl.glEnd();

        // the arrow heads
        gl.glBegin(GL.GL_TRIANGLES);
        gl.glVertex2d(0, 150);
        gl.glVertex2d(-5, 140);
        gl.glVertex2d(5, 140);
        gl.glVertex2d(0, -150);
        gl.glVertex2d(-5, -140);
        gl.glVertex2d(5, -140);
        gl.glVertex2d(250, 0);
        gl.glVertex2d(240, -5);
        gl.glVertex2d(240, 5);
        gl.glVertex2d(-250, 0);
        gl.glVertex2d(-240, -5);
        gl.glVertex2d(-240, 5);
        gl.glEnd();
    }

    private void drawPlane(GL gl) {

        gl.glPushMatrix();

        // applied to the plane from the last line to the first:
        // scale, then rotate, then move
        gl.glTranslated(translateXValue, translateYValue, 0);
        gl.glRotated(rotateAngleValue, 0, 0, 1);
        gl.glScaled(scaleXValue, scaleYValue, 1);

        // body
        gl.glColor3f(0.7f, 0.7f, 0.7f);
        drawRectangle(gl, -50, -10, 80, 20);

        // nose
        gl.glColor3f(1, 0, 0);
        drawTriangle(gl, 30, -10, 30, 10, 50, 0);

        // wings
        gl.glColor3f(0.2f, 0.4f, 1);
        drawTriangle(gl, 10, 10, -25, 10, -35, 50);
        drawTriangle(gl, 10, -10, -25, -10, -35, -50);

        // tail fins
        gl.glColor3f(0, 0.7f, 0.6f);
        drawTriangle(gl, -38, 10, -50, 10, -50, 28);
        drawTriangle(gl, -38, -10, -50, -10, -50, -28);

        // cockpit
        gl.glColor3f(0.6f, 0.85f, 1);
        drawCircle(gl, 20, 0, 5);

        gl.glPopMatrix();
    }

    // circle: center (cx, cy), radius r
    private void drawCircle(GL gl, double cx, double cy, double r) {
        gl.glBegin(GL.GL_POLYGON);
        for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE) {
            gl.glVertex2d(r * Math.cos(a) + cx, r * Math.sin(a) + cy);
        }
        gl.glEnd();
    }

    // rectangle: bottom-left corner (x, y), width w, height h
    private void drawRectangle(GL gl, double x, double y, double w, double h) {
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2d(x, y);
        gl.glVertex2d(x + w, y);
        gl.glVertex2d(x + w, y + h);
        gl.glVertex2d(x, y + h);
        gl.glEnd();
    }

    // triangle: three corner points
    private void drawTriangle(GL gl, double x1, double y1, double x2, double y2, double x3, double y3) {
        gl.glBegin(GL.GL_TRIANGLES);
        gl.glVertex2d(x1, y1);
        gl.glVertex2d(x2, y2);
        gl.glVertex2d(x3, y3);
        gl.glEnd();
    }
}