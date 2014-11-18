package GameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import MainFrames.Screen;
import Props.Global;

public class Wooden implements GameObject{

	private Point location ;  //ľͷλ��
	private int width,length; //ľͷ�Ĵ�С
	private Screen screen;
	
	public Wooden(int x,int y ,Screen screen){
		this.screen = screen;
		location = new Point(x,y);
		width = Global.WOODEN_WIDTH;
		length = Global.WOODEN_LENGTH;
	}
	
	/**
	 * �ж��Ƿ��ӵ�����
	 * @param bump
	 * @return
	 */
	public boolean isShot(Bump bump){
		System.out.println("���ľͷ�Ƿ��ӵ�����");
		return false;
	}
	
	@Override
	public void DrawMe(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.yellow);
		g.drawRect((int)location.getX(), (int)location.getY(), width, length);
	}

	/**
	 * �õ������size���Լ����ײ
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
