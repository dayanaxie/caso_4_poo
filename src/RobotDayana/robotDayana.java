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

import patronObserver.Observable;
import patronObserver.Observer;
import robotwar.common.robotbase.IRobot;
import robotwar.common.robotbase.MOVEMENT;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class robotDayana extends IRobot implements Observer{
	private  String rutaImagenes = "../caso_4_poo/src/Images/";
	private String route = "";
	private JLabel robotLabel;
	
	public robotDayana(List<String> pWeaponsAndStrikes){
		super(ORIENTATION.EAST, 2);
		this.speed = 4;
		this.energy = 100;
		assingSpikesAndGuns(pWeaponsAndStrikes);
		//chargeImage();
	}
	
	public void assingSpikesAndGuns(List<String> pWeaponsAndStrikes) {
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
	
	@Override
	public void addStrike(Weapon pStrike) {
		if(pStrike instanceof HachaD) {
			route += "H";
		}
		else {
			route += "M";
		}
		strikes[strikeIndex] = pStrike;
		strikeIndex=++strikeIndex%STRIKES_PER_ROBOT;
	}
	
	@Override
	public void addWeapon(Weapon pStrike) {
		if(pStrike instanceof LanzaCohetesD) {
			route += "L";
		}
		else {
			route += "P";
		}
		weapons[weaponIndex] = pStrike;
		weaponIndex=++weaponIndex%WEAPONS_PER_ROBOT;
	}
	
	public int getEnergy() {
		return this.energy;
	}
	
	public void setEnergy(int pEnergy) {
		this.energy = pEnergy;
	}
	
	public JPanel paintRobot(JPanel pArenaPanel, int x, int y) {
		pArenaPanel.add(robotLabel, 0);
		Dimension imageSize = robotLabel.getPreferredSize();
		robotLabel.setBounds(x, y, imageSize.width, imageSize.height);
		
		return pArenaPanel;

	}
	
	public void chargeImage() {
		BufferedImage robotImage = null;
		try {
			
			robotImage = ImageIO.read(new File(rutaImagenes + route + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image robotResized = robotImage.getScaledInstance(900, 600, Image.SCALE_DEFAULT);
		robotLabel = new JLabel(new ImageIcon(robotResized));
		
	}
	
	public String getRoute() {
		return route;
	}
	
	
	public JLabel getRobotLabel() {
		return robotLabel;
	}

	public Weapon[] getWeapons() {
		return this.weapons;
		
	}
	
	public Weapon[] getStrikes() {
		return this.strikes;
		
	}

	@Override
	public void updateEnergy(int pDamage) {
		this.energy += pDamage;
		System.out.println("Energia del robot: " + this.energy); 
		
	}


	
	
}
