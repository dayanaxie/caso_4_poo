package robotwar.utils;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.Timer;
public class DrawAreaArena extends JComponent implements ActionListener{
	private String image = "C:\\Users\\Oscar Campos Argueda\\eclipse-workspace\\case#4\\src\\robotwar\\images\\R.png";
	private int x = 350;
    private int y = 350;
	Timer t;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DrawAreaArena() {
		t = new Timer(10, this);
		this.setOpaque(true);
	}
///case#4/src/robotwar/images/R.png
	@Override
	public void actionPerformed(ActionEvent e) {
		
	repaint();	
	}
	
	public void paint (Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image bol = toolkit.getImage(image);
		g2D.drawImage(bol, x,y,this);
		t.start();
		//g.drawRect(100,40,1000,700);
	}
}
