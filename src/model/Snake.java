package model;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import config.GameConfig;

public class Snake implements GameObject {
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int RIGHT = 2;
	public static final int LEFT = 3;

	private Point head;
	private List<Point> body;
	private int archor;

	private boolean isRender;

	public Snake() {
		newSnake();
	}

	public void newSnake() {

		head = new Point(GameConfig.col / 3, GameConfig.row / 2);
		body = new ArrayList<Point>();
		archor = Snake.RIGHT;
		body.add(new Point(GameConfig.col / 3 - 3, GameConfig.row / 2));
		body.add(new Point(GameConfig.col / 3 - 2, GameConfig.row / 2));
		body.add(new Point(GameConfig.col / 3 - 1, GameConfig.row / 2));
	}

	public boolean isEatApple(Apple apple) {
		if (head.equals(apple.getLocation())) {
			body.add(new Point(apple.getLocation()));
			return true;
		} else
			return false;
	}

	@Override
	public void draw(Graphics g) {
		isRender = true;
		g.setColor(GameConfig.bodyColor);
		for (Point point : body) {
			g.fillRect(point.x * GameConfig.size, point.y * GameConfig.size, GameConfig.size, GameConfig.size);
		}
		g.setColor(GameConfig.headColor);
		g.fillRect(head.x * GameConfig.size, head.y * GameConfig.size, GameConfig.size, GameConfig.size);
	}

	public boolean isInSnake(Point p) {
		if (head.equals(p))
			return true;
		for (Point point : body)
			if (point.equals(p))
				return true;
		return false;
	}

	public boolean isEatSelf() {
		for (Point point : body)
			if (point.equals(head))
				return true;

		return false;
	}

	public void move() {
		Point temp = new Point(head);
		body.add(temp);
		switch (archor) {
		case UP: {
			head.translate(0, -1);
			break;
		}
		case LEFT: {
			head.translate(-1, 0);
			break;
		}
		case RIGHT: {
			head.translate(1, 0);
			break;
		}
		case DOWN:
			head.translate(0, 1);
		}
		body.remove(0);
	}

	public boolean hitWall(Wall wall) {
		List<Point> wallbody = wall.getBody();
		for (Point point : wallbody)
			if (point.equals(head))
				return true;
		return false;
	}

	public void changeArchor(int archor) {

		if (this.archor == UP && archor == DOWN)
			return;
		if (this.archor == DOWN && archor == UP)
			return;
		if (this.archor == RIGHT && archor == LEFT)
			return;
		if (this.archor == LEFT && archor == RIGHT)
			return;
		if (isRender) {
			this.archor = archor;
			isRender = false;
		}
	}
}
