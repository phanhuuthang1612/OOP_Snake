package control;

import java.awt.Graphics;

public interface IController {

	public void start();

	public void moveUp();
	
	public void moveLeft();

	public void moveRight();

	public void moveDown();

	public void ronate();

	public void pause();

	public void lose();

	public void resume();
	
	public void setLevel(int level);
	
	public int getLevel();
}
