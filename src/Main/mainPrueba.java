package Main;

import Arena.ArenaDayana;
import UI.ArenaFrameController;
import UI.MenuController;

public class mainPrueba {
	public static void main(String[] args) {
		//ArenaFrameController controller = new ArenaFrameController();
		
		//ArenaDayana ui = new ArenaDayana("Arena de Dayana", controller);
		
		MenuController menuController = new MenuController();
		
		MenuFrame menu = new MenuFrame("Menu", menuController);
		
		
	}

}
