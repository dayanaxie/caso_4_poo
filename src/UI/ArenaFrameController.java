package UI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Arena.ArenaDayana;

public class ArenaFrameController {
	private ArenaDayana controlledFrame;
	//private ArenaDayana controlledFrame;
	
	public ArenaFrameController() {
		
	}
	
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
				pArena.showImage(pArenaPanel, x, y, pDamageLabel);
				x -= 20;
			}
			else if((x>=520)&&(x<=670)&&(y<=385)&&(y>275)) {
				pArena.showImage(pArenaPanel, x, y, pDamageLabel);
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
				x += 20;
			}
			else if((x>=520)&&(x<=670)&&(y<=385)&&(y>275))  {
				pArena.showImage(pArenaPanel, x, y, pDamageLabel);
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
				y -= 20;//25;//50;//75;
			}
			else if((x>=520)&&(x<=670)&&(y<=385)&&(y>275)) {
				pArena.showImage(pArenaPanel, x, y, pDamageLabel);
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
				y += 20;//25;//50;//75;
			}
			else if((x>=520)&&(x<=670)&&(y<=385)&&(y>275)) {
				pArena.showImage(pArenaPanel, x, y, pDamageLabel);
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
		

}
