package GameObject;

import java.awt.Graphics;
import java.awt.Point;

public interface GameObject {
	
	/**
	 * ��������Ϸ����
	 * @param g
	 */
	public void DrawMe(Graphics g);
	/**
	 * �õ���Ϸ���嵱ǰ����
	 * @return
	 */
	public Point getLoacation();
}
