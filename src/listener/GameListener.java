package listener;

public interface GameListener {
	/**
	 * 开始游戏
	 */
	public boolean startGame();
	/**
	 * 停止游戏
	 */
	public boolean stopGame();
	/**
	 * 游戏失败
	 */
	public boolean gameOver();
	/**
	 * 游戏暂停
	 */
	public boolean gamePause();
}
