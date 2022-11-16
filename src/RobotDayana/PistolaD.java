package RobotDayana;

import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class PistolaD extends Weapon{
	
	public PistolaD() {
		super(25, 9, 300);
		this.setLevel(4);
	}
		



	@Override
	protected void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		
		
	}

}
