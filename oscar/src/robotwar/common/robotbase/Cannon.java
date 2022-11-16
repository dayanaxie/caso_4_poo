package robotwar.common.robotbase;

public class Cannon extends Weapon{
	
	
	public Cannon(int pSpeed, int pLevel, int pAttackDistance) {
		super(pSpeed, pLevel, pAttackDistance);
		
	}

	@Override
	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		if (pDirection.getValue() == 0) {
			
		}
	}

}
