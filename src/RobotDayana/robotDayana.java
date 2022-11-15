package RobotDayana;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import robotwar.common.robotbase.IRobot;
import robotwar.common.robotbase.MOVEMENT;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class robotDayana extends IRobot{
	private  String rutaImagenes = "../caso_4_poo/src/Images/";
	
	public robotDayana(List<String> pWeaponsAndStrikes){
		super(ORIENTATION.EAST, 2);
		// para buscar si selecciono lanza cohetes
		pWeaponsAndStrikes.stream().filter(s -> s.startsWith("L")).forEach(cohete -> this.addWeapon(new LanzaCohetesD()));
		// para buscar si selecciono pistola
		pWeaponsAndStrikes.stream().filter(s -> s.startsWith("P")).forEach(pistola -> this.addWeapon(new PistolaD()));
		// buscar si selecciono hacha 
		pWeaponsAndStrikes.stream().filter(s -> s.startsWith("H")).forEach(hacha -> this.addStrike(new HachaD()));
		// buscar si selecciono martillo
		pWeaponsAndStrikes.stream().filter(s -> s.startsWith("M")).forEach(martillo -> this.addStrike(new MartilloD()));
	}

	@Override
	protected void refreshMove(MOVEMENT pMove, LocalTime pActionTime, Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	// usar los fors para recorrer una lisat que tenga todo lo que el usuario escogio
	public void paintRobot(JPanel pArenaPanel, int x, int y) {
		
		pArenaPanel.add(pImageLabel, 0);
		Dimension imageSize = pImageLabel.getPreferredSize();
		pImageLabel.setBounds(x, y, imageSize.width, imageSize.height);
			
			
	
		
		//Stream<Weapon> stream = weapons.stream();
		//this.weaponsstream.forEach(null);
		
	}
	
	public JLabel getRobotImage() {
		IF 
		BufferedImage robotImage = null;
		try {
			
			robotImage = ImageIO.read(new File(rutaImagenes + "robotDayana.png"));
			damageImage = ImageIO.read(new File(rutaImagenes + "dañoPorTrampa.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image robotResized = robotImage.getScaledInstance(900, 600, Image.SCALE_DEFAULT);
		JLabel robotLabel = new JLabel(new ImageIcon(robotResized));
		return robotLabel;
	}
	
	public String getImagePath() {
		String path;
		for(int index = 0; index > weapons.length; ++ index) {
			
		}
		return path;
	}
	
	public Weapon[] getWeapons() {
		return this.weapons;
		
	}
	
	public Weapon[] getStrikes() {
		return this.strikes;
		
	}
	
	
}
