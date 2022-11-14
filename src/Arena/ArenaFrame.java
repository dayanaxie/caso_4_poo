package Arena;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import UI.ArenaFrameController;
import Main.IConstants;


public class ArenaFrame extends JFrame implements IConstants{
	private static final long serialVersionUID = 1L;
	private ArenaFrameController controller;
	ImageIcon robotD;
	ImageIcon trampaUno;

	
	public ArenaFrame(String pTitle, ArenaFrameController pController) {
		super(pTitle);
		controller = pController; // frame ve al controller
		controller.setWindow(this); // controller ve al frame
		
		// configuracion del panel
		JPanel arenaPanel = new	JPanel();
		arenaPanel.setSize(ARENA_WIDTH, ARENA_HEIGTH);
		
		
		// configuracion del frame
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(0, 0, ARENA_WIDTH, ARENA_HEIGTH);
		this.setLocationRelativeTo(null);
		this.setLayout(null); // this allows this frame to locate the components with freedom in the screen
		this.setBackground(Color.white);
		this.loadRobot();
		this.loadTraps();
		
		
		
		this.initComponents();
		
		this.setVisible(true);		
	}
	
	public void loadTraps() {
		File trampaUnoPath = new File("../caso_4_poo/src/Images/trampaCerrada.png");
		try {
			BufferedImage bufferedImage = ImageIO.read(trampaUnoPath);
			Image image = bufferedImage.getScaledInstance(700, 600, Image.SCALE_DEFAULT);
			trampaUno = new ImageIcon(image);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void loadRobot() {
		File dayanaRobotPath = new File("../caso_4_poo/src/Images/robotDayana.png");
		try {
			BufferedImage bufferedImage = ImageIO.read(dayanaRobotPath);
			Image image = bufferedImage.getScaledInstance(800, 900, Image.SCALE_DEFAULT);
			robotD = new ImageIcon(image);


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initComponents() {
		JLabel robotLabel = new JLabel();
		robotLabel.setBounds(30, 50, 800, 800);
		robotLabel.setIcon(robotD);
		this.add(robotLabel);
		
		JLabel trampaUnoLabel = new JLabel();
		trampaUnoLabel.setBounds(300, 500, 800, 800);
		trampaUnoLabel.setIcon(trampaUno);
		this.add(trampaUnoLabel);
		this.addKeyListener(null);
		
		//this.addKeyListener(null);

		
	}
	

}
