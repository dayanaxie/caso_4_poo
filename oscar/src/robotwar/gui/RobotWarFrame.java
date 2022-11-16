package robotwar.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.TextField;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
	private Image robot;
	private Image logo;
	private Image trampaU; //Trampa 1
	private Image trampaD; //Trampa 2
	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private RobotWarController controller;
	public int dir = 0;
	private int yRobot;
	private int xRobot;
	private JLabel trampaLabelU;
	private JTextField cajaText;
	private JButton boton;
	private Graphics2D g2D;
	
	public RobotWarFrame(String pTitle, RobotWarController pController) {
		super(pTitle);
		
		controller = pController;
		controller.gameFrame(this);
		imagenRobot();
		 
	    
	     boton = new JButton();
	     
	    iconoFrame();
	    cajaTexto();
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    colocarPanel();

		personalizarFrame();
		colocarTrampaU();
		restablecer();
	}
	
	public void colocarTrampaU() {
		this.trampaU = new ImageIcon(ruta + "clavo.png").getImage();
	    Image modTrampa = trampaU.getScaledInstance(90,90, Image.SCALE_SMOOTH);
	    this.trampaU = new ImageIcon(modTrampa).getImage();
	    
	}
	
	public void personalizarFrame() {
		this.setBounds(0, 0, IConstants.ARENA_WIDTH, IConstants.ARENA_HEIGTH);
		this.setResizable(false);
		this.setLocationRelativeTo(null); 
		this.setBackground(Color.white);
		this.setVisible(true); 
	}
	
	public void colocarPanel() {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setBounds(100, 100, 450, 300);
		 contentPane = new JPanel();
		 contentPane.setBorder(new EmptyBorder(50, 50, 50, 50));
		 contentPane.setLayout(null);
		 setContentPane(contentPane);
	}
	
	public void cajaTexto() {
		cajaText = new JTextField();
	    cajaText.setBounds(50, 50, 100, 30);
	}
	
	public void iconoFrame() {
		this.logo = new ImageIcon(ruta + "Logo.png").getImage();
	    this.logo = new ImageIcon(logo.getScaledInstance(20,20, Image.SCALE_SMOOTH)).getImage();
	    this.setIconImage(logo);
	}
	
	public void imagenRobot() {
		this.robot = new ImageIcon(ruta + "robot.png").getImage();
	    Image modRobot = robot.getScaledInstance(90,90, Image.SCALE_SMOOTH);
	    this.robot = new ImageIcon(modRobot).getImage();
	}
	
	public void paint(Graphics g){
	    super.paintComponents(g);
	   
	    g2D = (Graphics2D) g;
	    
        g2D.rotate(Math.toRadians(0), 500 , 250);
        //g2D.drawImage(robot, x+350, y+250, null);
		g2D.drawImage(robot, xRobot+350, yRobot+250, 200, 200, null);
		g2D.drawImage(trampaU, 800, 510, 300, 300,null);
		g2D.drawRect(10, 40, 140, 740);
		g2D.drawRect(150, 40, 1050, 90);
		g2D.drawRect(150, 685, 1050, 90);
	}
	public void initComponents() {
	}
	
	public int getX() {
		return this.xRobot;
	}
	
	public int getY() {
		return this.yRobot;
	}
	public void MoveRobotX(int pX) {
		this.xRobot += pX;
	}
	
	public void MoveRobotY(int pY) {
		this.yRobot += pY;
	}

	public void habilitarChat(boolean bool) {
		
		if (bool) {
		cajaText.setVisible(bool);
		boton.setVisible(bool);
		
		this.add(cajaText);
		this.add(boton);
		
		boton.setBounds(50, 90, 500, 500);
		cajaText.setBounds(50, 50, 100, 30);
		
		repaint();
		}
		
		if (bool == false) {
			boton.setVisible(bool);
			cajaText.setVisible(bool);
			repaint();
			
		}
			
	}
	
	public void restablecer() {
		boton = new JButton();
		boton.setBounds(50, 90, 500, 500);
		
		ActionListener oírB;
		
		oírB = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				habilitarChat(false);
				
			}
		};
				
		boton.addActionListener(oírB);

	}

	
}
