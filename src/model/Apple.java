package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import config.GameConfig;
import config.GameAsset;

public class Apple implements GameObject {
	private Point location;

	public Apple() {
		super();
		this.location = new Point(0, 0);
	}

	public Point getLocation() {
		return location;
	}

	@Override
	public void draw(Graphics g) {
		Image appImg = GameAsset.getInstance().apple;
		g.drawImage(appImg, location.x * GameConfig.size, location.y * GameConfig.size, GameConfig.size,
				GameConfig.size, null);
	}

	public void setLocation(Point location) {
		this.location = location;

	}
}
