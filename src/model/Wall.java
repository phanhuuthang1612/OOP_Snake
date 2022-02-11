package model;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import defaul.GameConfig;

public class Wall implements GameObject {

	List<Point> wallCube;

	public Wall() {
		wallCube = new ArrayList<Point>();
		for (int i = 0; i < GameConfig.col; i++) {
			wallCube.add(new Point(0, i));
			wallCube.add(new Point(GameConfig.frameWidth - 1, i));
		}
		for (int i = 0; i < GameConfig.row; i++) {
			wallCube.add(new Point(0, i));
			wallCube.add(new Point(GameConfig.frameWidth - 1, i));
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(GameConfig.headColor);
		for (Point point : wallCube) {
			g.drawRect(point.x, point.y, GameConfig.size, GameConfig.size);
		}

	}

}
