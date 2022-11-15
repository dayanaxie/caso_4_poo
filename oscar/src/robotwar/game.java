package robotwar;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.io.Console;
import java.time.LocalTime;

import javax.swing.plaf.synth.SynthGraphicsUtils;

import robotwar.common.IConstants;
import robotwar.common.robotbase.DamageLevel;
import robotwar.common.robotbase.MOVEMENT;
import robotwar.common.robotbase.Robot;
import robotwar.common.robotbase.Weapon;
import robotwar.common.robotbase.WeaponFire;
import robotwar.common.robotbase.WeaponStrike;
import robotwar.controller.RobotWarController;
import robotwar.gui.RobotWarFrame;
import robotwar.utils.Observer;

public class game {

	public static void main(String[] args) throws InterruptedException {
	
		Robot r = Robot.getInstance();
		RobotWarController cont = new RobotWarController(r);
		
		//RobotWarFrame robotWar = new RobotWarFrame("Robot War", cont);
		
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	RobotWarFrame robotWar = new RobotWarFrame("Robot War", cont);
                    robotWar.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
		
		//r.notificar();
		//System.out.println(r.toString());
		
		// while (true){
		//	 Thread.sleep(3000);
		// }
		 
	}
}