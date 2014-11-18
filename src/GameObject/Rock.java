package GameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import MainFrames.Screen;
import Props.Global;

public class Rock implements GameObject {

	private Point location ; //石头坐标
	private int width,length; //石头大小
	private Screen screen; 
	
	public Rock(int x ,int y ,Screen screen){
		location = new Point(x,y);
		this.screen = screen ; 
		width = Global.ROCK_WIDTH;
		length = Global.ROCK_LENGTH;
	}
	
	/**
	 * 检测石头是否被子弹打中
	 * @param bump
	 * @return
	 */
	public boolean isShot(Bump bump){
		System.out.println("检测石头是否被子弹打中");
		return this.getRect().intersects(bump.getRect());
	}
	
	/**
	 * 得到物体的size用以检测碰撞
	 * @return
	 */
	public Rectangle getRect(){
		return new Rectangle((int)location.getX(), (int)location.getY(), width, length);
	}
	
	@Override
	public void DrawMe(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.gray);
		g.drawRect((int)location.getX(), (int)location.getY(), width, length);
		System.out.println("draw the rock");
	}

	@Override
	public Point getLoacation() {
		// TODO Auto-generated method stub
		return null;
	}

}
