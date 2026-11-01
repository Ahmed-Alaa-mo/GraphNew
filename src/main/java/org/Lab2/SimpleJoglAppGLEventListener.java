package org.Lab2;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class SimpleJoglAppGLEventListener implements GLEventListener {
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

        GL gl = glAutoDrawable.getGL();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        //gl.glViewport(0, 0, 600, 300);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(0.0, 600.0, 0.0, 300.0, -1.0, 1.0);

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {

        GL gl = glAutoDrawable.getGL();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);  // to Clear if anything exist in the frame

        // First Point
        gl.glPointSize(13.0f);

        gl.glColor3f(1.0f, 0.0f, 0.0f);

        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2i ( 300,150);
        gl.glEnd();

        // Secound Point
        gl.glPointSize(33.0f);

        gl.glColor3f(0.0f, 1.0f, 0.0f);

        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2i ( 200,150);
        gl.glEnd();

        // Third Point
        gl.glPointSize(66.0f);
        gl.glColor3f(0.0f, 0.0f, 1.0f);

        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2i ( 400,150);
        gl.glEnd();

        // Drow Two Lines
        gl.glColor3f(0.2f, 0.4f, 0.6f);

        gl.glBegin(GL.GL_LINES);
        gl.glVertex2i(50,70);
        gl.glVertex2i(500,70);

        gl.glVertex2i(50,270);
        gl.glVertex2i(500,270);
        gl.glEnd();

        //شكل سداسى
        gl.glColor3f(0.2f, 0.4f, 0.6f);

        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(550,100);
        gl.glVertex2i(580,100);
        gl.glVertex2i(590,150);
        gl.glVertex2i(580,200);
        gl.glVertex2i(550,200);
        gl.glVertex2i(540,150);
        gl.glEnd();

     }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {
    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {
    }
}
