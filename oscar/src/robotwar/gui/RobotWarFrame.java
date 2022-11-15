package robotwar.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import robotwar.common.IConstants;
import robotwar.controller.RobotWarController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
public class RobotWarFrame extends JFrame {
	private String ruta = "C:\\Users\\Oscar Campos Argueda\\eclipse-workspace\\case#4\\src\\robotwar\\images\\";
	private BufferedImage robot;
	private Image logo;
	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private RobotWarController controller;
	public int dir = 0;
	private int y;
	private int x;

	
	public RobotWarFrame(String pTitle, RobotWarController pController) {
		super(pTitle);
		
		controller = pController;
		controller.gameFrame(this);
		
		try {
			this.robot = ImageIO.read(new File(ruta + "robot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   // Image modRobot = robot.getScaledInstance(90,90, Image.SCALE_SMOOTH);
	    //this.robot = new ImageIcon(modRobot).getImage();
	    
	    this.logo = new ImageIcon(ruta + "Logo.png").getImage();
	    this.logo = new ImageIcon(logo.getScaledInstance(90,90, Image.SCALE_SMOOTH)).getImage();
	    this.setIconImage(logo);
	    
	    
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 450, 300);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    contentPane.setLayout(new BorderLayout(0, 0));
	    setContentPane(contentPane);
	    setBounds(0,0,800,600);

		this.setBounds(0, 0, IConstants.ARENA_WIDTH, IConstants.ARENA_HEIGTH);
		this.setResizable(false);
		this.setLocationRelativeTo(null); 
		this.setBackground(Color.white);
		this.setVisible(true); 

		
	
	}
	
	public void paint(Graphics g){
	    super.paintComponents(g);
	    Graphics2D g2D;
	    
	    g2D = (Graphics2D) g;
	    
	    BufferedImage i = new BufferedImage(robot.getWidth(), robot.getHeight(), robot.getType());

        //g2D = newImageFromBuffer.createGraphics();
        g2D.rotate(Math.toRadians(0), robot.getWidth() / 2, robot.getHeight() / 2);
        g2D.drawImage(robot, x+500, y+125, null);
		
	}
	public void initComponents() {
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	public void MoveRobotX(int pX) {
		this.x += pX;
	}
	
	public void MoveRobotY(int pY) {
		this.y += pY;
	}

	
	
	
	
}
