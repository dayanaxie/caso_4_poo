package UI;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Arena.ArenaDayana;
import Arena.ArenaFrame;

public class ArenaFrameController {
	private ArenaDayana controlledFrame;
	//private ArenaDayana controlledFrame;
	
	public ArenaFrameController() {
		
	}
	
	public void setWindow(ArenaDayana pFrame) {
		controlledFrame = pFrame;
	}
	
	
	public int[] calculateDamageLocation(ArenaDayana pArena, JPanel pArenaPanel, JLabel pDamageLabel, int s, int x, int y) {
		if(pArena.isDirIzq() || pArena.isDirDer()) {
			if(pArena.isDirIzq()) {
				if(x<=-100) {
					x = x;
					y = y;
				}
				else if((x>=950)&&(x<=1100)&&(y<=10)&&(y>-100)) {
					pArena.showDamage(pArenaPanel, x, y, pDamageLabel);
					x -= 20;
				}
				else if((y>=550)&&(x>=300)&&(x<=900)) {
					pArena.showDamage(pArenaPanel, x, y, pDamageLabel);
					x -= 20;
				}
				else if((y>=10)&&(y<=500)&&(x<=10)) {
					pArena.showDamage(pArenaPanel, x, y, pDamageLabel);
					x -= 20;
				}
				else {
					x -= 20;
				}
			}
			else if(pArena.isDirDer()) {
				if(x>=1200) {
					x = x;
					y = y;
				}
				else if((x>=950)&&(x<=1100)&&(y<=10)&&(y>-100)) {
					pArena.showDamage(pArenaPanel, x, y, pDamageLabel);
					x += 20;
				}
				else if((y>=550)&&(x>=300)&&(x<=900)) {
					pArena.showDamage(pArenaPanel, x, y, pDamageLabel);
					x += 20;
				}
				else if((y>=10)&&(y<=500)&&(x<=10)) {
					pArena.showDamage(pArenaPanel, x, y, pDamageLabel);
					x += 20;
				}
				else {
					x += 20;
				}
			}
			return x, y;
			
		}
		
			
		else if(pArena.isDirArriba()) {
			if(y<=-200) {
				x = x;
				y = y;
			}
			else if((x>=950)&&(x<=1100)&&(y<=10)&&(y>-100)) {
				pArena.showDamage(pArenaPanel, x, y, pDamageLabel);
				y -= 20;//25;//50;//75;
			}
			else if((y>=550)&&(x>=300)&&(x<=900)) {
				pArena.showDamage(pArenaPanel, x, y, pDamageLabel);
				y -= 20;//25;//50;//75;
			}
			else if((y>=10)&&(y<=500)&&(x<=10)) {
				pArena.showDamage(pArenaPanel, x, y, pDamageLabel);
				y -= 20;//25;//50;//75;
			}
			else {
				y -= 20;//25;//50;//75;
			}
		}
		else if(pArena.isDirAbajo()) {
			if(y>=600) {
				x = x;
				y = y;
			}
			else if((x>=950)&&(x<=1100)&&(y<=10)&&(y>-100)) {
				pArena.showDamage(pArenaPanel, x, y, pDamageLabel);
				y += 20;//25;//50;//75;
			}
			else if((y>=550)&&(x>=300)&&(x<=900)) {
				pArena.showDamage(pArenaPanel, x, y, pDamageLabel);
				y += 20;//25;//50;//75;
			}
			else if((y>=10)&&(y<=500)&&(x<=10)) {
				pArena.showDamage(pArenaPanel, x, y, pDamageLabel);
				y += 20;//25;//50;//75;
			}
			else {
				y += 20;//25;//50;//75;
			}
			
		}
		return x;
		
		
	}
		

		

	
	void calculateRefresh(JPanel panel1, int s, int x, int y) {
		//panel1.removeAll();
		panel1.remove(picLabel);
		panel1.remove(picLabel2);
		s++;
		
		if(dirIzq == true) {
			if(x<=-100) {
				x = x;
				y = y;
			}
			else if((x>=950)&&(x<=1100)&&(y<=10)&&(y>-100)) {
				//x = x;
				//y = y;
				mostrarDano(panel1, x, y, picLabel2);
				x -= 20;//25;//50;//75;
			}
			else if((y>=550)&&(x>=300)&&(x<=900)) {
				//x = x;
				//y = y;
				mostrarDano(panel1, x, y, picLabel2);
				x -= 20;//25;//50;//75;
			}
			else if((y>=10)&&(y<=500)&&(x<=10)) {
				//x = x;
				//y = y;
				mostrarDano(panel1, x, y, picLabel2);
				x -= 20;//25;//50;//75;
			}
			else {
				x -= 20;//25;//50;//75;
			}
		}
		else if(dirDer == true) {
			if(x>=1200) {
				x = x;
				y = y;
			}
			else if((x>=950)&&(x<=1100)&&(y<=10)&&(y>-100)) {
				//x = x;
				//y = y;
				mostrarDano(panel1, x, y, picLabel2);
				x += 20;//25;//50;//75;
			}
			else if((y>=550)&&(x>=300)&&(x<=900)) {
				//x = x;
				//y = y;
				mostrarDano(panel1, x, y, picLabel2);
				x += 20;//25;//50;//75;
			}
			else if((y>=10)&&(y<=500)&&(x<=10)) {
				//x = x;
				//y = y;
				mostrarDano(panel1, x, y, picLabel2);
				x += 20;//25;//50;//75;
			}
			else {
				x += 20;//25;//50;//75;
			}
		}
		else if(dirArriba == true) {
			if(y<=-200) {
				x = x;
				y = y;
			}
			else if((x>=950)&&(x<=1100)&&(y<=10)&&(y>-100)) {
				//x = x;
				//y = y;
				mostrarDano(panel1, x, y, picLabel2);
				y -= 20;//25;//50;//75;
			}
			else if((y>=550)&&(x>=300)&&(x<=900)) {
				//x = x;
				//y = y;
				mostrarDano(panel1, x, y, picLabel2);
				y -= 20;//25;//50;//75;
			}
			else if((y>=10)&&(y<=500)&&(x<=10)) {
				//x = x;
				//y = y;
				mostrarDano(panel1, x, y, picLabel2);
				y -= 20;//25;//50;//75;
			}
			else {
				y -= 20;//25;//50;//75;
			}
		}
		else if(dirAbajo == true) {
			if(y>=600) {
				x = x;
				y = y;
			}
			else if((x>=950)&&(x<=1100)&&(y<=10)&&(y>-100)) {
				//x = x;
				//y = y;
				mostrarDano(panel1, x, y, picLabel2);
				y += 20;//25;//50;//75;
			}
			else if((y>=550)&&(x>=300)&&(x<=900)) {
				//x = x;
				//y = y;
				mostrarDano(panel1, x, y, picLabel2);
				y += 20;//25;//50;//75;
			}
			else if((y>=10)&&(y<=500)&&(x<=10)) {
				//x = x;
				//y = y;
				mostrarDano(panel1, x, y, picLabel2);
				y += 20;//25;//50;//75;
			}
			else {
				y += 20;//25;//50;//75;
			}
		
		
		
	}

}
