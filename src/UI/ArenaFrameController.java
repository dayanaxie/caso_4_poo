package UI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Arena.ArenaDayana;
import patronObserver.Observable;
import patronObserver.Observer;

public class ArenaFrameController implements Observable{
	private ArenaDayana controlledFrame;	
	public ArrayList<Observer> observers = new ArrayList<Observer>();


	public void setWindow(ArenaDayana pFrame) {
		controlledFrame = pFrame;
	}
	
	
	public List<Integer> calculateDamageLocation(ArenaDayana pArena, JPanel pArenaPanel, JLabel pDamageLabel, int s, int x, int y) {
		List<Integer> coordinates = new ArrayList<Integer>();  
		if(pArena.isDirIzq()) {
			if(x<=-100) {
				x = x;
				y = y;
			}
			else if((x>=200)&&(x<=350)&&(y<=-125)&&(y>-235)) {
				this.notifyObservers(-5);
				pArena.showImage(pArenaPanel, x, y, pDamageLabel);
				x -= 20;
			}
			else if((x>=520)&&(x<=670)&&(y<=385)&&(y>275)) {
				pArena.showImage(pArenaPanel, x, y, pDamageLabel);
				this.notifyObservers(-5);
				x -= 20;
			}
			else {
				x -= 20;
			}
		}
		else if(pArena.isDirDer()) {
			if(x >= 1200) {
				x = x;
				y = y;
			}
			else if((x>=200)&&(x<=350)&&(y<=-125)&&(y>-235)) {
				pArena.showImage(pArenaPanel, x, y, pDamageLabel);
				this.notifyObservers(-5);
				x += 20;
			}
			else if((x>=520)&&(x<=670)&&(y<=385)&&(y>275))  {
				pArena.showImage(pArenaPanel, x, y, pDamageLabel);
				this.notifyObservers(-5);
				x += 20;
			}
			else {
				x += 20;
			}
		}
		else if(pArena.isDirArriba()) {
			if(y<=-200) {
				x = x;
				y = y;
			}
			else if((x>=200)&&(x<=350)&&(y<=-125)&&(y>-235)) {
				pArena.showImage(pArenaPanel, x, y, pDamageLabel);
				this.notifyObservers(-5);
				y -= 20;//25;//50;//75;
			}
			else if((x>=520)&&(x<=670)&&(y<=385)&&(y>275)) {
				pArena.showImage(pArenaPanel, x, y, pDamageLabel);
				this.notifyObservers(-5);
				y -= 20;//25;//50;//75;
			}
			else {
				y -= 20;//25;//50;//75;
			}
		}
		else if(pArena.isDirAbajo()) {
			if(y>=400) {
				x = x;
				y = y;
			}
			else if((x>=200)&&(x<=350)&&(y<=-125)&&(y>-235))  {
				pArena.showImage(pArenaPanel, x, y, pDamageLabel);
				this.notifyObservers(-5);
				y += 20;//25;//50;//75;
			}
			else if((x>=520)&&(x<=670)&&(y<=385)&&(y>275)) {
				pArena.showImage(pArenaPanel, x, y, pDamageLabel);
				this.notifyObservers(-5);
				y += 20;//25;//50;//75;
			}

			else {
				y += 20;//25;//50;//75;
			}
			
		}
		coordinates.add(x);
		coordinates.add(y);
		
		return coordinates;
	}


	@Override
	public void addObserver(Observer pObservable) {
		observers.add(pObservable);
		
	}

	@Override
	public void removeObserver(Observer pObservable) {
		observers.remove(pObservable);
		
	}

	@Override
	public void notifyObservers(int pValue) {
		for(Observer observer : observers) {
			observer.updateEnergy(pValue);
		}
		
	}
		

}
