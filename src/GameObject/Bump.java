 package GameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import MainFrames.Screen;
import Props.Direction;
import Props.Global;

public class Bump implements GameObject{

	private Point location;	 //ը������
	private Direction direction; //�ڵ�����
	private int width,length;	//�ڵ���С
	private boolean live;		 //�ڵ�����
	private boolean good; 		//����ӵ��ĺû�
	private int speed; //�ڵ������ٶ�
	private Screen screen;
	
	public Bump(int x,int y,Direction direction,boolean good,Screen screen){
		location = new Point(x, y);
		speed = 10;
		this.direction = direction;
		this.screen = screen;
		this.good = good;
		width = Global.BUMP_WIDTH;
		length = Global.BUMP_LENGTH;
		live = true;
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
		g.setColor(Color.red);
		g.drawRect((int)location.getX(), (int)location.getY(), width, length);
		move();
	}

	public void move(){
		switch (direction) {
		case W:
			location.setLocation(location.getX(), location.getY()-speed);
			break;
		case S:
			location.setLocation(location.getX(), location.getY()+speed);
			break;
		case A:
			location.setLocation(location.getX()-speed, location.getY());
			break;
		case D:
			location.setLocation(location.getX()+speed, location.getY());
			break;
		default:
			break;
		}
		if (location.getX() < 0 || location.getY() < 0 || location.getX() > Global.SCREEN_WIDTH
				|| location.getY() > Global.SCREEN_LENGTH) {
			live = false;
		}
		isBump();
	}
	
	@Override
	public Point getLoacation() {
		// TODO Auto-generated method stub
		return location;
	}

	/**
	 * �����ײ��̹��
	 * @return
	 */
	public boolean isKnockTank(){
		for(Tank s : screen.getEnermy()){
			if(this.getRect().intersects(s.getRect())){
				if(s.isGood()!=this.isGood()){
					screen.getEnermy().remove(s);
					return true;
				}
				else
					return false;
			}
		}
		return false;
	}
	
	/**
	 * �����ײ��ľͷ
	 * @return
	 */
	public boolean isKnockWooden(){
		for(Wooden s : screen.getWooden()){
			if(this.getRect().intersects(s.getRect())){
				screen.getWooden().remove(s);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * �����ײ��ʯͷ
	 * @return
	 */
	public boolean isKnockRock(){
		for(Rock s : screen.getRock()){
			if(this.getRect().intersects(s.getRect())){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * �ж��Ƿ�ײ������
	 * @return
	 */
	public boolean isBump(){
		if(isKnockTank()||isKnockRock()||isKnockWooden()){
			System.out.println("ը��̹��");
			live = false;
			return true;
		}
		return false;
	}

	public boolean isGood() {
		return good;
	}

	public boolean isLive() {
		return live;
	}
	
}
