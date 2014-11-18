package Paper;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import GameObject.Bump;
import GameObject.GameObject;
import GameObject.Tank;
import GameObject.Wooden;
import MainFrames.Screen;

public class Canvas extends JPanel implements Runnable {

	private Screen screen;
	private Thread tr = new Thread(this);

	/**
	 * ªÊª≠ŒÔÃÂ
	 */
	private ArrayList<GameObject> myGameObjects = new ArrayList<GameObject>();

	public Canvas() {
		Init();
		tr.start();
	}

	public Canvas(Screen screen) {
		Init();
		this.screen = screen;
		tr.start();
		repaint();

	}

	/**
	 * ≥ı ºªØª≠≤º
	 */
	public void Init() {
		setSize(500, 500);
		setVisible(true);
		setBackground(Color.gray);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		for (Wooden c : screen.getWooden()) {
			c.DrawMe(g);
		}
		for (Tank c : screen.getEnermy()) {
			c.DrawMe(g);
		}
		Iterator<Bump> iter = screen.getBump().iterator();
		while (iter.hasNext()) {
			Bump b = iter.next();
			if (b.isLive()) {
				b.DrawMe(g);
			}else
			{
				System.out.println("…æ≥˝’®µØ");
				iter.remove();
			}
		}
		if (screen.getTank() != null) {
			screen.getTank().DrawMe(g);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (screen.stopGame() == false) {
			this.repaint();
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("∆¡ƒª ”ÕºªÊª≠ ß∞‹");
			}
		}
	}

}
