package GameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import MainFrames.Screen;
import Props.Global;

public class Rock implements GameObject {

	private Point location ; //ʯͷ����
	private int width,length; //ʯͷ��С
	private Screen screen; 
	
	public Rock(int x ,int y ,Screen screen){
		location = new Point(x,y);
		this.screen = screen ; 
		width = Global.ROCK_WIDTH;
		length = Global.ROCK_LENGTH;
	}
	
	/**
	 * ���ʯͷ�Ƿ��ӵ�����
	 * @param bump
	 * @return
	 */
	public boolean isShot(Bump bump){
		System.out.println("���ʯͷ�Ƿ��ӵ�����");
		return this.getRect().intersects(bump.getRect());
	}
	
	/**
	 * �õ������size���Լ����ײ
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
