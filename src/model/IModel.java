package model;

import java.awt.Graphics;

public interface IModel {
	void start();

	void pause();

	void setLevel(int level);

	void getLevel();

	void draw(Graphics g);

	void moveLeft();

	void moveRight();

	void moveUp();

	void moveDown();
}
