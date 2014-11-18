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
 * ��ɫ������
 * @author Administrator
 *
 */
public class PlayerControl extends KeyAdapter implements PlayerListener{
   
	private Screen screen;		//��Ϸ������
	private Tank tank; 			//����
	
	public PlayerControl(Screen screen){
		this.screen = screen;
		tank = screen.getTank();
	}
	
	@Override
    public void playerPutBump() {
		System.out.println("��������ɫ��ը��");
    }

    @Override
    public void playerMove() {
    	System.out.println("������̹���ƶ�");
    }
	
	public PlayerControl(Tank tank){
		this.tank = tank;
	}
	
	/**
	 * �������ƽ�ɫ�ƶ�
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
