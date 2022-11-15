package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import UI.MenuController;

public class MenuFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private MenuController controller;
	private String [] weaponOptions ={"Lanza cohetes", "Pistola"};
	private String [] golpesOptions ={"Hacha", "Martillo"};
	private String [] robotOptions = {"RobotHechoEnCanva"};
	
	public MenuFrame(String pTitle, MenuController pController) {
		super(pTitle);
		controller = pController; // frame ve al controller
		controller.setWindow(this); // controller ve al frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(null); // this allows this frame to locate the components with freedom in the screen
		this.setBackground(Color.white);
		this.initComponents();
		this.setVisible(true);		

		
	}
	private void initComponents() {
		BufferedImage robotWars = null;
		try {
			
			robotWars = ImageIO.read(new File("../caso_4_poo/src/Images/robotWars.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image logo = robotWars.getScaledInstance(300, 150, Image.SCALE_DEFAULT);
		JLabel logoLabel = new JLabel(new ImageIcon(logo));
		Dimension logooSize = logoLabel.getPreferredSize();
		logoLabel.setBounds(125, 20, logooSize.width, logooSize.height);
		this.add(logoLabel);
		
		JLabel robot = new JLabel("Seleccione el robot que desea usar: ");
		robot.setBounds(20, 200, 300, 20);
    	this.add(robot);

    	
    	JComboBox robotsAvailable = new JComboBox(robotOptions);
    	robotsAvailable.setBounds(250, 200, 150, 20);
    	this.add(robotsAvailable);
    	
    	JLabel weaponOne = new JLabel("Seleccione el arma 1: ");
    	weaponOne.setBounds(20, 250, 300, 20);
    	this.add(weaponOne);
    	
    	JComboBox weaponAvailable = new JComboBox(weaponOptions);
    	weaponAvailable.setBounds(250, 250, 150, 20);
    	this.add(weaponAvailable);
    	
    	JLabel weaponTwo = new JLabel("Seleccione el arma 2: ");
    	weaponTwo.setBounds(20, 300, 300, 20);
    	this.add(weaponTwo);
    	
    	JComboBox weaponsAvailable = new JComboBox(weaponOptions);
    	weaponsAvailable.setBounds(250, 300, 150, 20);
    	this.add(weaponsAvailable);
    	
    	JLabel golpe = new JLabel("Seleccione el golpe ");
    	golpe.setBounds(20, 350, 300, 20);
    	this.add(golpe);
    	
    	JComboBox golpeAvailable = new JComboBox(golpesOptions);
    	golpeAvailable.setBounds(250, 350, 150, 20);
    	this.add(golpeAvailable);
    	
    	
    	JButton startButton = new JButton("Empezar");  
    	startButton.setBounds(200, 425, 150, 20);
    	startButton.addActionListener(new ActionListener(){  
    		public void actionPerformed(ActionEvent e){
    			//aqui se pone la coneccion con los sokects para empezar la partida y crear los robots
    		}  
    	});
    	this.add(startButton);
    	
		
		
	}
	

}
