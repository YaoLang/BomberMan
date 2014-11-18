package Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import GameObject.GameObject;
import GameObject.Rock;
import GameObject.Tank;
import GameObject.Wooden;
import MainFrames.Screen;
import listener.PlayerListener;

/**
 * 角色控制器
 * @author Administrator
 *
 */
public class PlayerControl extends KeyAdapter implements PlayerListener{
   
	private Screen screen;		//游戏监听器
	private Tank tank; 			//主角
	
	public PlayerControl(Screen screen){
		this.screen = screen;
		tank = screen.getTank();
	}
	
	@Override
    public void playerPutBump() {
		System.out.println("监听到角色放炸弹");
    }

    @Override
    public void playerMove() {
    	System.out.println("监听到坦克移动");
    }
	
	public PlayerControl(Tank tank){
		this.tank = tank;
	}
	
	/**
	 * 按键控制角色移动
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		tank.move(e);
	}

	public GameObject getTank(){
		return tank;
	}
}
