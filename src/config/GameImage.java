package config;

import java.awt.Image;

import javax.swing.ImageIcon;

public class GameImage {
	private static GameImage instance;
	public Image apple = new ImageIcon("image//apple.png").getImage();
	public Image background = new ImageIcon("image//background.png").getImage();
	public Image cup =  new ImageIcon("image/trophy_00.png").getImage();

	private GameImage() {

	}

	public static GameImage getInstance() {
		if (instance == null)
			return instance = new GameImage();

		return instance;
	}

}
