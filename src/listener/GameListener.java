package listener;

public interface GameListener {
	/**
	 * ��ʼ��Ϸ
	 */
	public boolean startGame();
	/**
	 * ֹͣ��Ϸ
	 */
	public boolean stopGame();
	/**
	 * ��Ϸʧ��
	 */
	public boolean gameOver();
	/**
	 * ��Ϸ��ͣ
	 */
	public boolean gamePause();
}
