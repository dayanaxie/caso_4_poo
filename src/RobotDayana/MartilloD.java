package RobotDayana;

import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class MartilloD extends Weapon{
	
	MartilloD(){
		super(25, 9, 300);
		this.setLevel(5);
	}

	@Override
	protected void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		// TODO Auto-generated method stub
		
	}

}
