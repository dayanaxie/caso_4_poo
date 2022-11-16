package robotwar.common.robotbase;

import java.awt.Graphics;
import java.awt.Image;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import robotwar.utils.Observable;
import robotwar.utils.Observer;


//El uso del observable en esta clase es que almacene en una 
//lista las partes de los robots, esto para tener la retro-
//alimentación esperada.
public class Robot extends IRobot implements Observable{
	private static Robot single_instance = null;
	private ArrayList<Observer> estadoPart;

	
	public Robot() {
		super();
		estadoPart = new ArrayList<>();
		

	}
	
	public static Robot getInstance()
    {
        if (single_instance == null)
        	
            single_instance = new Robot();
        return single_instance;
    }

	public void asignarArmas() {
		
	}
	/*
	 * @pLevel, número del nivel del arma que le acertó
	 * este es el nivel del arma o golpe que le acertó a este robot
	 * entonces ahora hay que dado el nivel escoger la regla que aplica
	 * actualizar el damage respectivo
	 */
	public void damage(int pLevel) {
		
	}
	
	public int getEnergy() {
		return this.energy;
	}
	
	public void setEnergy(int pEnergy) {
		this.energy = pEnergy;
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
