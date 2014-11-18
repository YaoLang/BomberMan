package Props;

import java.awt.Rectangle;

/**
 * 配置信息，包括窗口大小，还有各种默认值的设置，由灼彬负责
 * 任务：在此类中设置各种全局变量，通过读取properties文件获取其默认值，之后就可以通过修改配置文件直接改变默认值
 * 参考：去查看properties文件的读取操作，把值都放在properties文件下读取。
 * @author Administrator
 *
 */
public class Global {
	/**
	 * 窗口配置
	 */
	public final static int SCREEN_WIDTH = 800;
	public final static int SCREEN_LENGTH = 600;
	/**
	 * 坦克配置
	 */
	public final static int TANK_WIDTH = 35;
	public final static int TANK_LENGTH = 35;
	public final static int TANK_SPEED = 6;
	public final static int TANK_GOOD_LIVE = 3;
	public final static int TANK_BAD_LIVE = 1;
	/**
	 * 子弹配置
	 */
	public final static int BUMP_WIDTH = 10;
	public final static int BUMP_LENGTH = 10;
	/**
	 * 木头配置
	 */
	public final static int WOODEN_WIDTH = 20;
	public final static int WOODEN_LENGTH = 20;
	/**
	 * 石头配置
	 */
	public final static int ROCK_WIDTH = 30;
	public final static int ROCK_LENGTH = 30;
}
