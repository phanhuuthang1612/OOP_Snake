package model;

import java.awt.Point;
import java.util.List;

public class Snake {

	Point head;
	List<Point> body;

	public Snake(Point head, List<Point> body) {
		this.head = head;
		this.body = body;
	}

}
