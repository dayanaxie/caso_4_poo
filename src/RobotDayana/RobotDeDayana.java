package RobotDayana;

import java.awt.Graphics;
import java.time.LocalTime;

import Robot.DamageLevel;
import Robot.IRobot;
import Robot.MOVEMENT;
import Robot.Weapon;

import java.awt.Image;
import java.awt.event.KeyEvent;

public class RobotDeDayana extends robotwar.common.robotbase.IRobot{
	public RobotDeDayana() {
		super();
	}
	@Override
	public void move(robotwar.common.robotbase.MOVEMENT pMove, LocalTime pActionTime, Graphics g) {
		// put your code here
	}
	@Override
	public void hit(int pStrikeId, LocalTime pActionTime, Graphics g ) {
		
	}
	@Override
	public void fire(int pWeaponId, LocalTime pActionTime, Graphics g) {
		this.weapons[pWeaponId].fire(this.posX, this.posY, this.currentOrientation);
	}
	
	/*
	 * @pLevel, número del nivel del arma que le acertó
	 * este es el nivel del arma o golpe que le acertó a este robot
	 * entonces ahora hay que dado el nivel escoger la regla que aplica
	 * actualizar el damage respectivo
	 */
	@Override
	public void damage(int pLevel) {
		
	}
	public void setEnergy(int pEnergy) {
		super.energy = pEnergy;
	}
	public int getEnergy() {
		return super.energy;
	}
	

}
