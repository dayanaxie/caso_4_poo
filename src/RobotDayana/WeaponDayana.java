package RobotDayana;

import Robot.ORIENTATION;
import Robot.Weapon;

public class WeaponDayana extends Weapon{

	public WeaponDayana(int pSpeed) {
		super(pSpeed);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void fire(int pPosX, int pPosY, ORIENTATION pDirection) {
		if (this.isEnabled()) {
			triggerWeapon(pPosX, pPosY, pDirection);
		}
	}

	
	@Override
	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		
		
		
	}


}
