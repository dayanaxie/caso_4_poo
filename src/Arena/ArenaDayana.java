package Arena;
import robotwar.common.IConstants;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Image;

import UI.ArenaFrameController;



// se puede usar el patron de observer y observable para notificar al robot cada vez que haga daño con las trampas
// que le baje la vida
// solo que tenemos que tener en cuenta cual robot es el que esta encima de la trampa para afectar al robot correcto

public class ArenaDayana implements KeyListener, robotwar.common.IConstants{
	private static final long serialVersionUID = 1L;
	private ArenaFrameController controller;
	private boolean runningSimulation;
	private static String rutaImagenes = "../caso_4_poo/src/Images/";
	private int dir = 0;
	private boolean dirIzq = false;
	private boolean dirDer = false;
	private boolean dirArriba = false;
	private boolean dirAbajo = false;
	
	// el super es frame
	
	public ArenaDayana(String pTitle, ArenaFrameController pController){
		controller = pController; // frame ve al controller
		controller.setWindow(this); // controller ve al frame
		runningSimulation = true;
		// configuracion del panel
		JPanel arenaPanel = new	JPanel();
		arenaPanel.setSize(ARENA_WIDTH, ARENA_HEIGTH);
		arenaPanel.setLayout(null);
		arenaPanel.setBackground(Color.white);
		// configuracion del frame
		JFrame arenaFrame = new JFrame(pTitle);
		arenaFrame.addKeyListener(this);
		arenaFrame.getContentPane();
		arenaFrame.add(arenaPanel);
		arenaFrame.setSize(ARENA_WIDTH, ARENA_HEIGTH);
		arenaFrame.setLocationRelativeTo(null);
		arenaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		arenaFrame.setVisible(true);
		startArena(arenaPanel);
	}
	
	public void startArena(JPanel pArenaPanel) {
		BufferedImage robotImage = null;
	    BufferedImage damageImage = null;
		try {
			
			robotImage = ImageIO.read(new File(rutaImagenes + "robotDayana.png"));
			damageImage = ImageIO.read(new File(rutaImagenes + "dañoPorTrampa.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image robotResized = robotImage.getScaledInstance(900, 600, Image.SCALE_DEFAULT);
		JLabel robotLabel = new JLabel(new ImageIcon(robotResized));
		Image damageResized = damageImage.getScaledInstance(900, 600, Image.SCALE_DEFAULT);
		JLabel damageLabel = new JLabel(new ImageIcon(damageResized));
		
		showTraps(pArenaPanel);
		putBackground(pArenaPanel);
		int counter = 0;
		int x = 0;
		int y = 0;
		while (runningSimulation) {
			//System.out.println("contador: " + counter);
			List<Integer> coordinates = new ArrayList<Integer>();  
			pArenaPanel.remove(robotLabel);
			pArenaPanel.remove(damageLabel);
			++ counter;
			coordinates = controller.calculateDamageLocation(this, pArenaPanel, damageLabel, counter, x, y);
			x = coordinates.get(0);
			y = coordinates.get(1);
			try {
				// tiempo de refrescado
				showImage(pArenaPanel, x, y, robotLabel);
				Thread.sleep(50);
			}
			catch(Exception ex){
				ex.printStackTrace();
				
			}
			pArenaPanel.revalidate();
			pArenaPanel.repaint();
			
		}
		
	}
	
		
	
	public void showImage(JPanel pArenaPanel, int x, int y, JLabel pImageLabel) {
		pArenaPanel.add(pImageLabel, 0);
		Dimension imageSize = pImageLabel.getPreferredSize();
		pImageLabel.setBounds(x, y, imageSize.width, imageSize.height);
		
		
	}
	

	void showTraps(JPanel panel) {
		try {
			BufferedImage pinchosImage = null;
			pinchosImage = ImageIO.read(new File(rutaImagenes + "pinchos.png"));
			Image pinchosResized = pinchosImage.getScaledInstance(800, 600, Image.SCALE_DEFAULT);
			JLabel pinchosLabel = new JLabel(new ImageIcon(pinchosResized));
			panel.add(pinchosLabel);
			Dimension pinchoSize = pinchosLabel.getPreferredSize();
			pinchosLabel.setBounds(250, -135, pinchoSize.width, pinchoSize.height);
			//250, -135
	        
	        BufferedImage fuegoImage = null;
	        fuegoImage = ImageIO.read(new File(rutaImagenes + "fuego.png"));
	        Image fuegoResized = fuegoImage.getScaledInstance(800, 600, Image.SCALE_DEFAULT);
			JLabel fuegoLabel = new JLabel(new ImageIcon(fuegoResized));
			panel.add(fuegoLabel);
			Dimension fuegoSize = fuegoLabel.getPreferredSize();
			fuegoLabel.setBounds(570, 375, fuegoSize.width, fuegoSize.height);

		} catch (IOException e) {
			System.out.println("Error cargando imagen ");
			e.printStackTrace();
		}
		
	}
	void putBackground(JPanel pArenaPanel) {
		
		try {
			BufferedImage myPicture = null;
			myPicture = ImageIO.read(new File(rutaImagenes + "pisoCemento.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			//picLabel.setLocation(100, 500);
			pArenaPanel.add(picLabel);
			Dimension size = picLabel.getPreferredSize();
	        picLabel.setBounds(-25, -50, size.width, size.height);
	        //panel.setComponentZOrder(picLabel, 3);
		} catch (IOException e) {
			System.out.println("Error cargando imagen ");
			e.printStackTrace();
		}
        
    }



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
	    if (key == KeyEvent.VK_LEFT) {
	        dirIzq = true;
	    }

	    else if (key == KeyEvent.VK_RIGHT) {
	        dirDer = true;
	    }

	    else if (key == KeyEvent.VK_UP) {
	        dirArriba = true;
	    }

	    else if (key == KeyEvent.VK_DOWN) {
	        dirAbajo = true;
	    }
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
	    if (key == KeyEvent.VK_LEFT) {
	        dirIzq = false;
	    }

	    else if (key == KeyEvent.VK_RIGHT) {
	        dirDer = false;
	    }

	    else if (key == KeyEvent.VK_UP) {
	        dirArriba = false;
	    }

	    else if (key == KeyEvent.VK_DOWN) {
	        dirAbajo = false;
	    }
		
	}


	public boolean isRunningSimulation() {
		return runningSimulation;
	}


	public void setRunningSimulation(boolean runningSimulation) {
		this.runningSimulation = runningSimulation;
	}


	public int getDir() {
		return dir;
	}


	public void setDir(int dir) {
		this.dir = dir;
	}


	public boolean isDirIzq() {
		return dirIzq;
	}


	public void setDirIzq(boolean dirIzq) {
		this.dirIzq = dirIzq;
	}


	public boolean isDirDer() {
		return dirDer;
	}


	public void setDirDer(boolean dirDer) {
		this.dirDer = dirDer;
	}


	public boolean isDirArriba() {
		return dirArriba;
	}


	public void setDirArriba(boolean dirArriba) {
		this.dirArriba = dirArriba;
	}


	public boolean isDirAbajo() {
		return dirAbajo;
	}


	public void setDirAbajo(boolean dirAbajo) {
		this.dirAbajo = dirAbajo;
	}


	
	

}
