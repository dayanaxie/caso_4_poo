package robotwar.common.robotbase;

public abstract class Weapon extends DamageLevelP{
	protected int posX;
	protected int posY;
	protected int speed;
	protected int level;
	protected int attackDistance;
	
	public Weapon(int pSpeed, int pLevel, int pAttackDistance) {
		this.speed = pSpeed;
		this.level = pLevel;
		this.attackDistance = pAttackDistance;
		
	}

	public void fire(int pPosX, int pPosY, ORIENTATION pDirection) {
		if (this.isEnabled()) { //Si está parte del robot llega a cero de energia se desabilita, quedando así sin poder disparar
			triggerWeapon(pPosX, pPosY, pDirection);
		}
	}
	
	public abstract void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection);
	
	

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
