package model;

import java.awt.Graphics;

public interface IModel {
	void newGame();

	void start();

	void pause();

	void setLevel(int level);

	int getLevel();

	void draw(Graphics g);

	void moveLeft();

	void moveRight();

	void moveUp();

	void moveDown();

	int getHighScore();

	int getPoint();
}
