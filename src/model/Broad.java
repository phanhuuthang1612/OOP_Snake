package model;

import java.awt.Graphics;

public class Broad implements IModel {
	Apple apple;
	Snake snake;
	Wall wall;
	private int highScore;

	public Broad(Apple apple, model.Snake snake, Wall wall) {
		super();
		this.apple = apple;
		this.snake = snake;
		this.wall = wall;
		highScore = 0;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLevel(int level) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getLevel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getHighScore() {
		// TODO Auto-generated method stub
		return this.highScore;
	}

}
