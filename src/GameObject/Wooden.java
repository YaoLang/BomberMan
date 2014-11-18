package GameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import MainFrames.Screen;
import Props.Global;

public class Wooden implements GameObject{

	private Point location ;  //木头位置
	private int width,length; //木头的大小
	private Screen screen;
	
	public Wooden(int x,int y ,Screen screen){
		this.screen = screen;
		location = new Point(x,y);
		width = Global.WOODEN_WIDTH;
		length = Global.WOODEN_LENGTH;
	}
	
	/**
	 * 判断是否被子弹打中
	 * @param bump
	 * @return
	 */
	public boolean isShot(Bump bump){
		System.out.println("检测木头是否被子弹打中");
		return false;
	}
	
	@Override
	public void DrawMe(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.yellow);
		g.drawRect((int)location.getX(), (int)location.getY(), width, length);
	}

	/**
	 * 得到物体的size用以检测碰撞
	 * @return
	 */
	public Rectangle getRect(){
		return new Rectangle((int)location.getX(), (int)location.getY(), width, length);
	}
	
	@Override
	public Point getLoacation() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
