package MainFrames;
/*		第四次上传到GitHub		*/
/* 第六次，吃了肯地基吧  */
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;

import listener.GameListener;
import Controller.PlayerControl;
import GameObject.Bump;
import GameObject.GameObject;
import GameObject.Rock;
import GameObject.Tank;
import GameObject.Wooden;
import Paper.Canvas;
import Props.Global;

public class Screen extends JFrame implements GameListener{
	
	private PlayerControl playControl;
	private Tank tank; 			//主角
	private List<Tank> enermy = new ArrayList<Tank>(); 	//敌方坦克
	private List<Wooden> wooden = new ArrayList<Wooden>();  //木头
	private List<Rock> rock = new ArrayList<Rock>();  //石头
	private List<Bump> bump = new ArrayList<Bump>();	//炮弹
	private Canvas canvas ;  //画布

	public static void main(String[] args) {
		Screen s = new Screen();
	}
	
	public Screen(){
		Init();
	}
	
	/**
	 * 初始化框架
	 * @throws
	 */
	private void Init(){
		setSize(Global.SCREEN_WIDTH, Global.SCREEN_LENGTH);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("start");
		tank = new Tank(20, 20, true,this);
		playControl = new PlayerControl(this);
		tank.addPlayerControl(playControl);
		addEnermy();
		addWooden();
		canvas = new Canvas(this);
		add(canvas);
		addKeyListener(playControl);
	}

	/**
	 * 添加敌人
	 */
	private void addEnermy(){
		Tank c ;
		for(int i = 0 ; i < 2;i++){
			c = new Tank(200*(i+1), 100*(i+1), false,this);
			enermy.add(c);
		}
	}
	
	private void addWooden(){
		Wooden c ;
		for(int i = 0 ; i<2 ; i ++){
			c = new Wooden(100*(i+1), 200*(i+1), this);
			wooden.add(c);
		}
	}
	
	/**
	 * 选择地图
	 */
	private void selectMap(){
		
	}
	
	public Tank getTank() {
		return tank;
	}

	public List<Tank> getEnermy() {
		return enermy;
	}

	public List<Wooden> getWooden() {
		return wooden;
	}

	public List<Rock> getRock() {
		return rock;
	}

	public  List<Bump> getBump() {
		return bump;
	}
	
	public Canvas getCanvas() {
		return canvas;
	}

	@Override
	public boolean startGame() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean stopGame() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gameOver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gamePause() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
