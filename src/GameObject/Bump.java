 package GameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import MainFrames.Screen;
import Props.Direction;
import Props.Global;

public class Bump implements GameObject{

	private Point location;	 //炸弹坐标
	private Direction direction; //炮弹方向
	private int width,length;	//炮弹大小
	private boolean live;		 //炮弹生命
	private boolean good; 		//标记子弹的好坏
	private int speed; //炮弹发射速度
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
	 * 得到物体的size用以检测碰撞
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
	 * 检测碰撞到坦克
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
	 * 检测碰撞到木头
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
	 * 检测碰撞到石头
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
	 * 判断是否撞到物体
	 * @return
	 */
	public boolean isBump(){
		if(isKnockTank()||isKnockRock()||isKnockWooden()){
			System.out.println("炸到坦克");
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
