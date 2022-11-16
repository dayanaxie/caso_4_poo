package Main;

import java.util.ArrayList;
import java.util.List;

import Arena.ArenaDayana;
import RobotDayana.robotDayana;
import UI.ArenaFrameController;

public class mainPrueba {
	public static void main(String[] args) {
		
		
		
		//MenuController menuController = new MenuController();
		
		//MenuFrame menu = new MenuFrame("Menu", menuController);
		List<String> pWeaponsAndStrikes = new ArrayList<>();
		pWeaponsAndStrikes.add("Hacha");
		pWeaponsAndStrikes.add("Pistola");
		pWeaponsAndStrikes.add("LanzaCohetes");
		robotDayana yo = new robotDayana(pWeaponsAndStrikes);
		ArenaFrameController controller = new ArenaFrameController();
		controller.addObserver(yo);
		ArenaDayana ui = new ArenaDayana("Arena de Dayana", controller, yo);
		//System.out.println("cantidad de golpes: " + yo.getStrikes().length);
		
	}

}
