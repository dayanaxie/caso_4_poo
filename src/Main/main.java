package Main;

import robotWarMain.menuController;
import robotWarMain.menuFrame;

public class main {
	public static void main(String[] args) {
		//ArenaFrameController controller = new ArenaFrameController();
		
		//ArenaDayana ui = new ArenaDayana("Arena de Dayana", controller);
		
		menuController menuController = new menuController();
		
		menuFrame menu = new menuFrame("RobotWars", menuController);
		
	}

}
