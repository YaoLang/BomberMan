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
	
	private Point location;	//��ǰ����
	private Point oldLocation; 	//��һ��������
	private int width,length;   //̹�˵Ĵ�С
	private Direction direction;	//̹�˷���
	private int live;				//̹�˵�����ֵ
	private int speed; 			//̹���ٶ�
	private boolean good; 		//���̹�˵ĺû�
	private PlayerListener playerListener;	//��ɫ������
	private Screen screen;	//��Ϸ����
	
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
	 * ̹���ƶ�
	 */
	public void move(KeyEvent e){
		changeDirection(e);
		if(isKnockTank()){
			System.out.println(1);
		}
		System.out.println("RockMan move");
	}
	
	/**
	 * �ı䷽��
	 * @param e
	 * ���ܼ�����Ϣ
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
	 * ̹�˿���
	 */
	public void fire(){
		Bump bump = new Bump((int)location.getX(),(int)location.getY(),direction,good,screen);
		screen.getBump().add(bump);
		System.out.println("̹�˷����ڵ�");
	}
	
	/**
	 * ��ɫ���˵�ǰһ��
	 */
	public void tuiBu(){
		location.setLocation(oldLocation);
	}
	
	/**
	 * �����ײ��̹��
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
	 * �õ������size���Լ����ײ
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
	 * �Д��Ƿ�����
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
