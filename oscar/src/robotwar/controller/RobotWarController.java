package robotwar.controller;

import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import robotwar.common.robotbase.Robot;
import robotwar.gui.RobotWarFrame;

import javax.swing.*;
import java.awt.*;

import java.awt.geom.Ellipse2D;


public class RobotWarController extends Thread implements ActionListener, KeyListener{
	int FPS = 30;
	RobotWarFrame controlledFrame;
	Robot robot;
	int vertical;
	int horizontal;
	private Timer timer;
	private double xVelocity = 0;
	private double yVelocity = 0;
	private int x;
	private int y;
	private boolean bool;
	Thread hilo;
	
	public RobotWarController(Robot robot){
		this.robot = robot;
		
		timer = new Timer(5, this);
	    this.timer.start();
	    bool = true;
	    
	    hilo = new Thread();
	    
	    hilo.start();
	}
	
	
	public void gameFrame(RobotWarFrame frame) {
		controlledFrame = frame;
		controlledFrame.addKeyListener(this);
	}
	
	 public void moveX(int pX){
	       this.x += pX;
	   }

	   public void moveY(int pY){
	       this.y += pY;
	   }
	public void moverRobot() {
		
	}

	public void up(){
		if (controlledFrame.getY() >=-120){
	       controlledFrame.MoveRobotY(-50);
	       controlledFrame.MoveRobotX(0);
	       controlledFrame.repaint();
		}
		
	    }

	 public void down() {
		 if (controlledFrame.getY() <=250){
		 controlledFrame.MoveRobotY(50); 
	     controlledFrame.MoveRobotX(0);
	     controlledFrame.repaint();
		 }
	    }

	 public void left(){
		 if (controlledFrame.getX() >=-200){
		 controlledFrame.MoveRobotY(0); 
	     controlledFrame.MoveRobotX(-50);
	     controlledFrame.repaint();
		 }
	    }

	 public void right(){
		 controlledFrame.MoveRobotY(0); 
	     controlledFrame.MoveRobotX(50);
	     controlledFrame.repaint();
	    }
	
	
	 public void enter() {
		 controlledFrame.habilitarChat(bool);
		 bool = !bool;
		 controlledFrame.repaint();
	 }
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

	    if(code == KeyEvent.VK_UP) {
	    	controlledFrame.MoveRobotY(0);
	    }
	    if(code == KeyEvent.VK_DOWN) {
	    	controlledFrame.MoveRobotY(0);
	    }
	    if(code == KeyEvent.VK_LEFT) {
	    	controlledFrame.MoveRobotX(0);
	    }
	    if(code == KeyEvent.VK_RIGHT) {
	    	controlledFrame.MoveRobotX(0);
	    }
	    
	    if(code == KeyEvent.VK_ESCAPE) {
	    	System.exit(code);
	    }  
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		 int code = e.getKeyCode();

	       if (code == KeyEvent.VK_UP) {
	           up(); 
	           System.out.println(controlledFrame.getX());
	}
	       if (code == KeyEvent.VK_DOWN)
	           down();
	       if (code == KeyEvent.VK_LEFT)
	           left();
	       if (code == KeyEvent.VK_RIGHT)
	           right();
		
	       if(code == KeyEvent.VK_ENTER) {
		       enter();
		    }
	       
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		x += xVelocity;
	    y += yVelocity;
	    //controlledFrame.repaint();
		}
	
	}



