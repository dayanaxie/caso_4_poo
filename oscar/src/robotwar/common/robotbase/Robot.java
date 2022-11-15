package robotwar.common.robotbase;

import java.awt.Graphics;
import java.time.LocalTime;
import java.util.ArrayList;
import robotwar.utils.Observable;
import robotwar.utils.Observer;

public class Robot extends IRobot implements Observable{
	private static Robot single_instance = null;
	private ArrayList<Observer> estadoPart;
	
	public Robot() {
		super();
		estadoPart =new ArrayList<>();
	}
	
	public static Robot getInstance()
    {
        if (single_instance == null)
        	
            single_instance = new Robot();
        return single_instance;
    }

	public void damage(int pLevel) {
		
	}
	
	public int getEnergy() {
		return this.energy;
	}
	
	@Override
	protected void refreshMove(MOVEMENT pMove, LocalTime pActionTime, Graphics g) {
		
		
	}
	
	
	
	
	@Override
	public void attach(Observer[] o) {
		for (int i = 0; i < o.length; i++) {
			estadoPart.add(o[i]);
		}
	}

	@Override
	public void detach(Observer o) {
		estadoPart.remove(o);
	}

	@Override
	public void notificar() {
		for (Observer observer : estadoPart) {
			observer.update();
		}
	}
}
