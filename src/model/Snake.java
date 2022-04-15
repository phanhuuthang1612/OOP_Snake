package model;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import config.GameConfig;
import config.GameAsset;
import config.SnakeArchor;

public class Snake {

	private Point head;
	private List<Point> body;
	private SnakeArchor archorHead;

	private boolean isRender;

	public Snake() {
		newSnake();
	}

	public void newSnake() {
		isRender = true;
		head = new Point(GameConfig.col / 3, GameConfig.row / 2);
		archorHead = SnakeArchor.RIGHT;

		body = new ArrayList<Point>();
		body.add(new Point(GameConfig.col / 3 - 3, GameConfig.row / 2));
		body.add(new Point(GameConfig.col / 3 - 2, GameConfig.row / 2));
		body.add(new Point(GameConfig.col / 3 - 1, GameConfig.row / 2));

	}

	private void drawPartOfBody(Point beforePart, Point currenPart, Point afterPart, Graphics g) {
		if (beforePart.y == afterPart.y)
			g.drawImage(GameAsset.getInstance().bodyHorizontal, currenPart.x * GameConfig.size,
					currenPart.y * GameConfig.size, GameConfig.size, GameConfig.size, null);
		else if (beforePart.x == afterPart.x)
			g.drawImage(GameAsset.getInstance().bodyVertical, currenPart.x * GameConfig.size,
					currenPart.y * GameConfig.size, GameConfig.size, GameConfig.size, null);
		else { // ve o 90
			int x = beforePart.x - afterPart.x;
			int y = beforePart.y - afterPart.y;
			if (x == -1 && y == -1) {
				if (currenPart.x == beforePart.x)
					g.drawImage(GameAsset.getInstance().bodyTopRight, currenPart.x * GameConfig.size,
							currenPart.y * GameConfig.size, GameConfig.size, GameConfig.size, null);
				else
					g.drawImage(GameAsset.getInstance().bodyBottomLeft, currenPart.x * GameConfig.size,
							currenPart.y * GameConfig.size, GameConfig.size, GameConfig.size, null);
			} else if (x == 1 && y == -1) {
				if (currenPart.y == beforePart.y)
					g.drawImage(GameAsset.getInstance().bodyBottomRight, currenPart.x * GameConfig.size,
							currenPart.y * GameConfig.size, GameConfig.size, GameConfig.size, null);
				else
					g.drawImage(GameAsset.getInstance().bodyTopLeft, currenPart.x * GameConfig.size,
							currenPart.y * GameConfig.size, GameConfig.size, GameConfig.size, null);
			} else if (x == 1 && y == 1) {
				if (currenPart.x == beforePart.x)
					g.drawImage(GameAsset.getInstance().bodyBottomLeft, currenPart.x * GameConfig.size,
							currenPart.y * GameConfig.size, GameConfig.size, GameConfig.size, null);
				else
					g.drawImage(GameAsset.getInstance().bodyTopRight, currenPart.x * GameConfig.size,
							currenPart.y * GameConfig.size, GameConfig.size, GameConfig.size, null);
			} else if (x == -1 && y == 1) {
				if (currenPart.y == beforePart.y)
					g.drawImage(GameAsset.getInstance().bodyTopLeft, currenPart.x * GameConfig.size,
							currenPart.y * GameConfig.size, GameConfig.size, GameConfig.size, null);
				else
					g.drawImage(GameAsset.getInstance().bodyBottomRight, currenPart.x * GameConfig.size,
							currenPart.y * GameConfig.size, GameConfig.size, GameConfig.size, null);
			}
		}
	}

	private void drawTail(Graphics g) {
		int x = body.get(0).x - body.get(1).x;
		int y = body.get(0).y - body.get(1).y;
		if (x == -1 && y == 0)
			g.drawImage(GameAsset.getInstance().tailLeft, body.get(0).x * GameConfig.size,
					body.get(0).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
		else if (x == 1 && y == 0)
			g.drawImage(GameAsset.getInstance().tailRight, body.get(0).x * GameConfig.size,
					body.get(0).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
		else if (x == 0 && y == -1)
			g.drawImage(GameAsset.getInstance().tailUp, body.get(0).x * GameConfig.size,
					body.get(0).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
		else if (x == 0 && y == 1)
			g.drawImage(GameAsset.getInstance().tailDown, body.get(0).x * GameConfig.size,
					body.get(0).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
	}

	private void drawHead(Graphics g) {
		switch (archorHead) {
		case UP:
			g.drawImage(GameAsset.getInstance().headUp, head.x * GameConfig.size, head.y * GameConfig.size,
					GameConfig.size, GameConfig.size, null);
			break;
		case DOWN:
			g.drawImage(GameAsset.getInstance().headDown, head.x * GameConfig.size, head.y * GameConfig.size,
					GameConfig.size, GameConfig.size, null);
			break;

		case LEFT:
			g.drawImage(GameAsset.getInstance().headLeft, head.x * GameConfig.size, head.y * GameConfig.size,
					GameConfig.size, GameConfig.size, null);
			break;

		case RIGHT:
			g.drawImage(GameAsset.getInstance().headRight, head.x * GameConfig.size, head.y * GameConfig.size,
					GameConfig.size, GameConfig.size, null);
			break;
		}
	}

	public void draw(Graphics g) {
		g.setColor(GameConfig.bodyColor);
		for (int i = 1; i < body.size(); i++)
			if (i != body.size() - 1) {
				drawPartOfBody(body.get(i + 1), body.get(i), body.get(i - 1), g);
			} else { // ve ke dau
				drawPartOfBody(head, body.get(i), body.get(i - 1), g);
			}
		drawTail(g);
		drawHead(g);
		isRender = true;
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

	public boolean moveAndIsEat(Apple apple) {
		Point temp = new Point(head);
		body.add(temp);
		switch (archorHead) {
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
		boolean ate = head.equals(apple.getLocation());
		if (!ate) {
			body.remove(0);
		}
		return ate;
	}

	public boolean hitWall(Wall wall) {
		List<Point> wallbody = wall.getBody();
		for (Point point : wallbody)
			if (point.equals(head))
				return true;
		return false;
	}

	public void changeArchor(SnakeArchor archor) {
		if (this.archorHead == SnakeArchor.UP && archor == SnakeArchor.DOWN)
			return;
		if (this.archorHead == SnakeArchor.DOWN && archor == SnakeArchor.UP)
			return;
		if (this.archorHead == SnakeArchor.RIGHT && archor == SnakeArchor.LEFT)
			return;
		if (this.archorHead == SnakeArchor.LEFT && archor == SnakeArchor.RIGHT)
			return;
		if (isRender) {
			this.archorHead = archor;
			isRender = false;
		}
	}
}
