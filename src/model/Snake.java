package model;

import java.awt.Point;
import java.util.List;

import defaul.GameConfig;

public class Snake {

	Point head;
	List<Point> body;

	public Snake() {
		head = new Point(4, GameConfig.row / 2);
	}

	public boolean isEatApple(Apple apple) {
		return head.equals(apple.getLocation());
	}
}
