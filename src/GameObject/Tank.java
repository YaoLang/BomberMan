package GameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import MainFrames.Screen;
import Props.Direction;
import Props.Global;
import listener.PlayerListener;

public class Tank implements GameObject{
	
	private Point location;	//当前坐标
	private Point oldLocation; 	//上一步的坐标
	private int width,length;   //坦克的大小
	private Direction direction;	//坦克方向
	private int live;				//坦克的生命值
	private int speed; 			//坦克速度
	private boolean good; 		//标记坦克的好坏
	private PlayerListener playerListener;	//角色控制器
	private Screen screen;	//游戏控制
	
	public Tank(int x , int y ,boolean good ,Screen screen){
		location = new Point(x, y); 
		oldLocation = new Point(x, y);
		this.playerListener = null;
		this.screen = screen;
		width = Global.TANK_WIDTH;
		length = Global.TANK_LENGTH;
		speed = Global.TANK_SPEED;
		this.good = good;
		direction = Direction.W;
	}
	
	/**
	 * 坦克移动
	 */
	public void move(KeyEvent e){
		changeDirection(e);
		if(isKnockTank()){
			System.out.println(1);
		}
		System.out.println("RockMan move");
	}
	
	/**
	 * 改变方向
	 * @param e
	 * 接受键盘信息
	 */
	public void changeDirection(KeyEvent e){
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			oldLocation.setLocation(location);
			location.setLocation(location.getX(), location.getY()-speed);
			direction = Direction.W;
			break;
		case KeyEvent.VK_DOWN:
			oldLocation.setLocation(location);
			location.setLocation(location.getX(), location.getY()+speed);
			direction = Direction.S;
			break;
		case KeyEvent.VK_LEFT:
			oldLocation.setLocation(location);
			location.setLocation(location.getX()-speed, location.getY());
			direction = Direction.A;
			break;
		case KeyEvent.VK_RIGHT:
			oldLocation.setLocation(location);
			location.setLocation(location.getX()+speed, location.getY());
			direction = Direction.D;
			break;
		case KeyEvent.VK_F:
			fire();
			break;
		default:
			break;
		}
	}
	
	/**
	 * 坦克开炮
	 */
	public void fire(){
		Bump bump = new Bump((int)location.getX(),(int)location.getY(),direction,good,screen);
		screen.getBump().add(bump);
		System.out.println("坦克发射炮弹");
	}
	
	/**
	 * 角色回退到前一步
	 */
	public void tuiBu(){
		location.setLocation(oldLocation);
	}
	
	/**
	 * 检测碰撞到坦克
	 * @return
	 */
	public boolean isKnockTank(){
		for(Tank s : screen.getEnermy()){
			if(this.getRect().intersects(s.getRect())){
				tuiBu();
				return true;
			}
		}
		return false;
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
		g.setColor(Color.blue);
		g.drawRect((int)location.getX(), (int)location.getY(),width, length);
	}

	/**
	 * 判斷是否死亡
	 * @return
	 */
	public boolean isDead(){
		return false;
	}

	@Override
	public Point getLoacation() {
		// TODO Auto-generated method stub
		return location;
	}

	public void addPlayerControl(PlayerListener l){
		playerListener = l;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public boolean isGood() {
		return good;
	}
	
}
