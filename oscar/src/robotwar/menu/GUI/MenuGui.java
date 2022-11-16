package robotwar.menu.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import robotwar.common.IConstants;
import robotwar.common.robotbase.Robot;
import robotwar.controller.RobotWarController;
import robotwar.gui.RobotWarFrame;
import robotwar.menu.controller.MenuController;

public class MenuGui extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MenuController controller;
	JButton buttonInit;
	JPanel panel;
	JLabel titulo;
	Image fondo;
	
	public MenuGui(String pTitle,MenuController pController){
		super(pTitle);
		
		controller = pController;
		controller.menuFrame(this);
		
		buttonInit = new JButton(); 
		panel = new JPanel();
		titulo = new JLabel();
		
		
		this.setBounds(0, 0, IConstants.ARENA_WIDTH, IConstants.ARENA_HEIGTH);
		this.setResizable(false);
		this.setLocationRelativeTo(null); 
		this.setBackground(Color.white);
		this.setVisible(true); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		imagenFondo("C:\\Users\\Oscar Campos Argueda\\eclipse-workspace\\case#4\\src\\robotwar\\images\\"+"Logo.png");
		this.setIconImage(fondo);
	    colocarPanel();
	    colocarBoton();
	    actionButton();
	    colocarLabel();
	   
		//panel.setVisible(true);
		
	}
	
	
	private void imagenFondo(String image) {
		this.fondo = new ImageIcon(image).getImage();
		this.fondo = new ImageIcon(fondo.getScaledInstance(20,20, Image.SCALE_SMOOTH)).getImage();
	}
	private void colocarLabel() {
		titulo.setBounds(550, 110, 250, 300);
		titulo.setVisible(true);
		titulo.setText("Robot War");
		panel.add(titulo);
		
	}

	void actionButton() {
		ActionListener oírButton = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.BuscarPartida();
				
			}
		};
		
		buttonInit.addActionListener(oírButton);
	}
	
	void colocarPanel() {
		panel.setBorder(new EmptyBorder(50, 50, 50, 50));
	    panel.setLayout(null);
	    setContentPane(panel);
	}
	
	void colocarBoton() {
		buttonInit.setBounds(500, 350, 150, 150);
		buttonInit.setVisible(true);
		buttonInit.setText("Iniciar");
		panel.add(buttonInit);
	}
		
	
}
