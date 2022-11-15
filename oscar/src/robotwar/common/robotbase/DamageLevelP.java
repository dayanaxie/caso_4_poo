package robotwar.common.robotbase;

import robotwar.utils.Observer;

public class DamageLevelP extends DamageLevel implements Observer{
	
	public DamageLevelP() {
		
	}
	
	@Override
	public void update() {
		System.out.println("Los niveles del arma son del "+ super.getDamageLevel());
	}

	
}
