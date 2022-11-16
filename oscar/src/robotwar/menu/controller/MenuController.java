package robotwar.menu.controller;

import java.awt.EventQueue;

import robotwar.common.robotbase.Robot;
import robotwar.controller.RobotWarController;
import robotwar.gui.RobotWarFrame;
import robotwar.menu.GUI.MenuGui;

public class MenuController {
	MenuGui controlledFrame;
	RobotWarController RobotWarController;
	Robot robot;
	public MenuController(Robot robot){
	this.robot = robot;
	
	
		
	}
	
	public void menuFrame(MenuGui frame){
		controlledFrame = frame;
	}
	
	void IniciarGame(){
		RobotWarController = new RobotWarController(getRobot());
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	RobotWarFrame robotWar = new RobotWarFrame("Robot War", RobotWarController);
                    robotWar.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}
	
	public void BuscarPartida()
	{
		IniciarGame();
		
	}
	
	
	public Robot getRobot() {
		return this.robot;
	}
}
