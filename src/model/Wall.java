package model;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import config.GameConfig;

public class Wall implements GameObject {

	List<Point> wallCube;

	public Wall() {
		wallCube = new ArrayList<Point>();
		for (int i = 0; i < GameConfig.row; i++) {
			wallCube.add(new Point(0, i));
			wallCube.add(new Point(GameConfig.col - 1, i));
		}
		for (int i = 0; i < GameConfig.col; i++) {
			wallCube.add(new Point(i, 0));
			wallCube.add(new Point(i, GameConfig.row - 1));
		}
	}

	@Override
	public void draw(Graphics g) {

		boolean fill = true;
		for (int i = 0; i < GameConfig.col; i++)
			for (int j = 0; j < GameConfig.row - 1; j++) {

				if (fill)
					g.setColor(GameConfig.backroundBroad1);
				else
					g.setColor(GameConfig.backroundBroad2);

				g.fillRect(i * GameConfig.size, j * GameConfig.size, GameConfig.size, GameConfig.size);
				fill = !fill;
			}

		g.setColor(GameConfig.backroundWall);
		for (Point point : wallCube) {
			g.fillRect(point.x * GameConfig.size, point.y * GameConfig.size, GameConfig.size, GameConfig.size);
		}

	}

	public boolean isInWall(Point point) {
		for (Point p : wallCube)
			if (p.equals(point))
				return true;
		return false;
	}
}
