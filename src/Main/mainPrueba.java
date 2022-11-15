package Main;

import java.util.ArrayList;
import java.util.List;

import Arena.ArenaDayana;
import RobotDayana.robotDayana;
import UI.ArenaFrameController;
import UI.MenuController;

public class mainPrueba {
	public static void main(String[] args) {
		//ArenaFrameController controller = new ArenaFrameController();
		
		//ArenaDayana ui = new ArenaDayana("Arena de Dayana", controller);
		
		//MenuController menuController = new MenuController();
		
		//MenuFrame menu = new MenuFrame("Menu", menuController);
		List<String> pWeaponsAndStrikes = new ArrayList<>();
		pWeaponsAndStrikes.add("Hacha");
		pWeaponsAndStrikes.add("Martillo");
		pWeaponsAndStrikes.add("Pistola");
		pWeaponsAndStrikes.add("LanzaCohetes");
		robotDayana yo = new robotDayana(pWeaponsAndStrikes);
		System.out.println("cantidad de armas: " + yo.getWeapons().toString());
		//System.out.println("cantidad de golpes: " + yo.getStrikes().length);
		
	}

}
