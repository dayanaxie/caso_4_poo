package Arena;
import robotwar.common.IConstants;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;


import UI.ArenaFrameController;



// se puede usar el patron de observer y observable para usar notificar al robot cada vez que haga daño con las trampas
// que le baje la vida

public class ArenaDayana extends JFrame implements KeyListener, robotwar.common.IConstants{
	private static final long serialVersionUID = 1L;
	private ArenaFrameController controller;
	private boolean runningSimulation;
	private static String rutaImagenes = "../caso_4_poo/src/Images/";
	private int dir = 0;
	private boolean dirIzq = false;
	private boolean dirDer = false;
	private boolean dirArriba = false;
	private boolean dirAbajo = false;
	
	
	public ArenaDayana(String pTitle, ArenaFrameController pController){
		super(pTitle);
		controller = pController; // frame ve al controller
		controller.setWindow(this); // controller ve al frame
		runningSimulation = true;
		// configuracion del panel
		JPanel arenaPanel = new	JPanel();
		arenaPanel.setSize(ARENA_WIDTH, ARENA_HEIGTH);
		BufferedImage robotImage = null;
	    BufferedImage damageImage = null;
		try {
			robotImage = ImageIO.read(new File(rutaImagenes + "robotDayana.png"));
			damageImage = ImageIO.read(new File(rutaImagenes + "dañoPorTrampa.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel robotLabel = new JLabel(new ImageIcon(robotImage));
		JLabel damageLabel = new JLabel(new ImageIcon(damageImage));
		// agregamos el panel al frame
		
		
		// configuracion del frame
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(0, 0, ARENA_WIDTH, ARENA_HEIGTH);
		this.setLocationRelativeTo(null);
		this.setLayout(null); // this allows this frame to locate the components with freedom in the screen
		this.setBackground(Color.white);
		this.add(arenaPanel);
		this.setVisible(true);
		
		showTraps(arenaPanel);
		int counter = 0;
		int x = 550;
		int y = 200;
		while (runningSimulation) {
			arenaPanel.remove(robotLabel);
			arenaPanel.remove(damageLabel);
			++ counter;
			if(dirIzq == true) {
				if(x<=-100) {
					x = x;
					y = y;
				}
				else {
					showDamage(arenaPanel, y, y, damageLabel);
					controller.calculateDamageLocation();
					
				}
				
				
				
				
				else if((x>=950)&&(x<=1100)&&(y<=10)&&(y>-100)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					x -= 20;//25;//50;//75;
				}
				else if((y>=550)&&(x>=300)&&(x<=900)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					x -= 20;//25;//50;//75;
				}
				else if((y>=10)&&(y<=500)&&(x<=10)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					x -= 20;//25;//50;//75;
				}
				else {
					x -= 20;//25;//50;//75;
				}
			}
			
		}
	}
	
	
	public void showDamage(JPanel panel, int x, int y, JLabel picLabel) {
		
	}
	
	
	
	
	
	
	void showTraps(JPanel panel) {
		try {
			BufferedImage pinchosImage = null;
			pinchosImage = ImageIO.read(new File(rutaImagenes + "pinchos.png"));
			JLabel pinchosLabel = new JLabel(new ImageIcon(pinchosImage));
			panel.add(pinchosLabel);
			Dimension pinchoSize = pinchosLabel.getPreferredSize();
			pinchosLabel.setBounds(1000, 0, pinchoSize.width, pinchoSize.height);
	        
	        BufferedImage fuegoImage = null;
	        fuegoImage = ImageIO.read(new File(rutaImagenes + "fuego.png"));
			JLabel fuegoLabel = new JLabel(new ImageIcon(fuegoImage));
			panel.add(fuegoLabel);
			Dimension fuegoSize = fuegoLabel.getPreferredSize();
			fuegoLabel.setBounds(350, 565, fuegoSize.width, fuegoSize.height);

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
