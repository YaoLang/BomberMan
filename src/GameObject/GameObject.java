package GameObject;

import java.awt.Graphics;
import java.awt.Point;

public interface GameObject {
	
	/**
	 * 画出该游戏物体
	 * @param g
	 */
	public void DrawMe(Graphics g);
	/**
	 * 得到游戏物体当前坐标
	 * @return
	 */
	public Point getLoacation();
}
