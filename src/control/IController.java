package control;

import java.awt.Graphics;

import model.IModel;

public interface IController {

	public void start();

	public void moveUp();
	
	public void moveLeft();

	public void moveRight();

	public void moveDown();

	public void pause();

	public void lose();

	public void resume();
	
	public void setLevel(int level);

	public IModel getModel();
}
