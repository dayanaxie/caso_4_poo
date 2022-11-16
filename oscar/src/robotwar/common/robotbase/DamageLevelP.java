package robotwar.common.robotbase;

import robotwar.utils.Observer;

/*
 Esta clase contiene el observer, esta puesto aquí no solo para las armas, 
 sino que tambien para las partes de los robots
 */
public class DamageLevelP extends DamageLevel implements Observer{
	
	
	@Override
	public void update() {
		System.out.println("Los niveles del arma son del "+ super.getDamageLevel());
	}

	
}
