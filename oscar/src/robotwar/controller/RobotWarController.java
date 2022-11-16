package robotwar.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;
import robotwar.common.robotbase.Robot;
import robotwar.gui.RobotWarFrame;



public class RobotWarController extends Thread implements ActionListener, KeyListener{
	private RobotWarFrame controlledFrame;
	private Robot robot;
	int vertical;
	int horizontal;
	private Timer timer;

	Thread hilo;
	private int pixelesActuales;

	
	public RobotWarController(Robot robot){
		this.robot = robot;
		
		timer = new Timer(5, this);
	    this.timer.start();
	    
	    hilo = new Thread();
	    
	    hilo.start();

	}
	
	
	public void gameFrame(RobotWarFrame frame) {
		controlledFrame = frame;
		controlledFrame.addKeyListener(this);
	}
	
	public void moverRobot() {
		
	}

	public void up(){
		if (controlledFrame.getY() >=200){
			pixelesActuales+=100;
	       controlledFrame.MoveRobotY(-100);
	       controlledFrame.MoveRobotX(0);
	       controlledFrame.repaint();
	       if ((controlledFrame.getX() >= 800) && (controlledFrame.getX() <= 850)) {
	    	   System.out.println("a");
	       }
	       if (pixelesActuales == 1000) {
	    	   robot.setEnergy(robot.getEnergy() -1);
	    	   pixelesActuales = 0;
	       }
		}
		
	    }

	 public void down() {
		 if (controlledFrame.getY() <=450){
		 controlledFrame.MoveRobotY(100); 
	     controlledFrame.MoveRobotX(0);
	     controlledFrame.repaint();
	     if ((controlledFrame.getX() >= 800) && (controlledFrame.getX() <= 850)) {
	    	   System.out.println("a");
	       }
	     if (pixelesActuales == 1000) {
	    	   robot.setEnergy(robot.getEnergy() -1);
	    	   pixelesActuales = 0;
	       }
		 }
	    }

	 public void left(){
		 if (controlledFrame.getX() >=100){
		 controlledFrame.MoveRobotY(0); 
	     controlledFrame.MoveRobotX(-100);
	     controlledFrame.repaint();
	     if ((controlledFrame.getX() >= 800) && (controlledFrame.getX() <= 850)) {
	    	   System.out.println("a");
	       }
	     if (pixelesActuales == 1000) {
	    	   robot.setEnergy(robot.getEnergy() -1);
	    	   pixelesActuales = 0;
	       }
		 }
	    }

	 public void right(){
		 controlledFrame.MoveRobotY(0); 
	     controlledFrame.MoveRobotX(100);
	     controlledFrame.repaint();
	     if ((controlledFrame.getX() >= 800) && (controlledFrame.getX() <= 850)) {
	    	   System.out.println("a");
	       }
	     if (pixelesActuales == 1000) {
	    	   robot.setEnergy(robot.getEnergy() -1);
	    	   pixelesActuales = 0;
	       }
	    }
	
	/*
	 public void enter() {
		 controlledFrame.habilitarChat(bool);
		 bool = !bool;
		 controlledFrame.repaint();
	 }
	 */
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
		
	    //   if(code == KeyEvent.VK_ENTER)
		  //     enter();
	       
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	    //controlledFrame.repaint();
		}
	
	}



