package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import defaul.GameConfig;

public class Apple implements GameObject {
	private Point location;
	private Image appleImg = new ImageIcon("image/apple.png").getImage();

	public Apple() {
		super();
		this.location = new Point(0, 0);
	}

	public Point getLocation() {
		return location;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(appleImg, location.x, location.y, GameConfig.size, GameConfig.size, null);
	}
}
