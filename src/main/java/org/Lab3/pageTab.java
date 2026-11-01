package org.Lab3;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;
import org.Lab2.SimpleJoglApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pageTab extends JFrame implements ActionListener, MouseMotionListener , MouseListener , KeyListener{
    private final JButton jButton1 ;
    private final JButton jButton2 ;

    private final JLabel jLabel1 ;
    private final JLabel jLabel2;
    private final JLabel jLabel3;
    private final JLabel jLabel4;

    private final JPanel jPanel;



    public static void main(String[] args) {

        new pageTab();
    }

    public pageTab (){

        jButton1 = new JButton("Reset") ;
        jButton2 =  new JButton("Exit");
        jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1,2,50,50));


        jLabel1 = new JLabel("Mouse X Coordinate");
        jLabel2 = new JLabel("Mouse Y Coordinate");
        jLabel3= new JLabel("Mouse Status");
        jLabel4= new JLabel("Total Mouse clicks");

        setLayout(new BorderLayout(10,10));

        jButton1.addActionListener(this);
        jButton2.addActionListener(this);


        jPanel.add(jButton1);
        jPanel.add(jButton2);


        setLayout(new FlowLayout(FlowLayout.LEFT , 150,30));
        add(jLabel1);
        add(jLabel2);
        add(jLabel3);
        add(jLabel4);


        this.add(jPanel,BorderLayout.SOUTH);


        this.addMouseMotionListener(this);
        this.addMouseListener(this);

        this.setFocusable(true);
        this.addKeyListener(this);






        setTitle("Event Tracker");
        setSize(500,700);
        setLocationRelativeTo(this);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(jButton1)){
            System.out.println("Restart Pressed");
        } else if (e.getSource().equals(jButton2)) {
            System.out.println("Exit Pressed");
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

         System.out.println("The Mouse now in (x,y)=("+ e.getX() +","+e.getY()+")");

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse Pressed now in (x,y)=("+ e.getX() +","+e.getY()+")");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse Released now in (x,y)=("+ e.getX() +","+e.getY()+")");
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("KeyEvent");
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("KeyPressed = LEFT");
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("KeyPressed = UP");
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("KeyPressed = Right");
        }else if (e.getKeyCode() == KeyEvent. VK_DOWN){
            System.out.println("KeyPressed = Down");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
