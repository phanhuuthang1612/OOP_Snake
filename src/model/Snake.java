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
	private List<SnakeArchor> bodyArchor;

	private boolean isRender;

	public Snake() {
		newSnake();
	}

	public void newSnake() {
		isRender = true;
		head = new Point(GameConfig.col / 3, GameConfig.row / 2);

		body = new ArrayList<Point>();
		bodyArchor = new ArrayList<SnakeArchor>();

		archorHead = SnakeArchor.RIGHT;

		body.add(new Point(GameConfig.col / 3 - 3, GameConfig.row / 2));
		body.add(new Point(GameConfig.col / 3 - 2, GameConfig.row / 2));
		body.add(new Point(GameConfig.col / 3 - 1, GameConfig.row / 2));

		bodyArchor.add(SnakeArchor.RIGHT);
		bodyArchor.add(SnakeArchor.RIGHT);
		bodyArchor.add(SnakeArchor.RIGHT);
	}

	public void draw(Graphics g) {
		g.setColor(GameConfig.bodyColor);
		for (int i = 1; i < body.size(); i++)
			if (i != body.size() - 1) { // ve khi khac ke dau
				if (body.get(i + 1).y == body.get(i - 1).y)
					g.drawImage(GameAsset.getInstance().bodyHorizontal, body.get(i).x * GameConfig.size,
							body.get(i).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
				else if (body.get(i + 1).x == body.get(i - 1).x)
					g.drawImage(GameAsset.getInstance().bodyVertical, body.get(i).x * GameConfig.size,
							body.get(i).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
				else { // ve o 90
					int x = body.get(i + 1).x - body.get(i - 1).x;
					int y = body.get(i + 1).y - body.get(i - 1).y;
					if (x == -1 && y == -1) {
						if (body.get(i).x == body.get(i + 1).x)
							g.drawImage(GameAsset.getInstance().bodyTopRight, body.get(i).x * GameConfig.size,
									body.get(i).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
						else
							g.drawImage(GameAsset.getInstance().bodyBottomLeft, body.get(i).x * GameConfig.size,
									body.get(i).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
					} else if (x == 1 && y == -1) {
						if (body.get(i).y == body.get(i + 1).y)
							g.drawImage(GameAsset.getInstance().bodyBottomRight, body.get(i).x * GameConfig.size,
									body.get(i).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
						else
							g.drawImage(GameAsset.getInstance().bodyTopLeft, body.get(i).x * GameConfig.size,
									body.get(i).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
					} else if (x == 1 && y == 1) {
						if (body.get(i).x == body.get(i + 1).x)
							g.drawImage(GameAsset.getInstance().bodyBottomLeft, body.get(i).x * GameConfig.size,
									body.get(i).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
						else
							g.drawImage(GameAsset.getInstance().bodyTopRight, body.get(i).x * GameConfig.size,
									body.get(i).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
					} else if (x == -1 && y == 1) {
						if (body.get(i).y == body.get(i + 1).y)
							g.drawImage(GameAsset.getInstance().bodyTopLeft, body.get(i).x * GameConfig.size,
									body.get(i).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
						else
							g.drawImage(GameAsset.getInstance().bodyBottomRight, body.get(i).x * GameConfig.size,
									body.get(i).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
					}
				}
			} else { // ve ke dau
				if (head.y == body.get(i - 1).y)
					g.drawImage(GameAsset.getInstance().bodyHorizontal, body.get(i).x * GameConfig.size,
							body.get(i).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
				else if (head.x == body.get(i - 1).x)
					g.drawImage(GameAsset.getInstance().bodyVertical, body.get(i).x * GameConfig.size,
							body.get(i).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
				else {
					int x = head.x - body.get(i - 1).x;
					int y = head.y - body.get(i - 1).y;
					if (x == -1 && y == -1) {
						if (body.get(i).x == head.x)
							g.drawImage(GameAsset.getInstance().bodyTopRight, body.get(i).x * GameConfig.size,
									body.get(i).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
						else
							g.drawImage(GameAsset.getInstance().bodyBottomLeft, body.get(i).x * GameConfig.size,
									body.get(i).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
					} else if (x == 1 && y == -1) {
						if (body.get(i).y == head.y)
							g.drawImage(GameAsset.getInstance().bodyBottomRight, body.get(i).x * GameConfig.size,
									body.get(i).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
						else
							g.drawImage(GameAsset.getInstance().bodyTopLeft, body.get(i).x * GameConfig.size,
									body.get(i).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
					} else if (x == 1 && y == 1) {
						if (body.get(i).x == head.x)
							g.drawImage(GameAsset.getInstance().bodyBottomLeft, body.get(i).x * GameConfig.size,
									body.get(i).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
						else
							g.drawImage(GameAsset.getInstance().bodyTopRight, body.get(i).x * GameConfig.size,
									body.get(i).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
					} else if (x == -1 && y == 1) {
						if (body.get(i).y == head.y)
							g.drawImage(GameAsset.getInstance().bodyTopLeft, body.get(i).x * GameConfig.size,
									body.get(i).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
						else
							g.drawImage(GameAsset.getInstance().bodyBottomRight, body.get(i).x * GameConfig.size,
									body.get(i).y * GameConfig.size, GameConfig.size, GameConfig.size, null);
					}
				}
			}

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
		bodyArchor.add(archorHead);
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
			bodyArchor.remove(0);
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
