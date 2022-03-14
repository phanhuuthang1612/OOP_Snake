package config;

import java.awt.Image;

import javax.swing.ImageIcon;

public class GameAsset {
	private static GameAsset instance;
	public Image apple = new ImageIcon("image/apple.png").getImage();
	public Image background = new ImageIcon("image/background.png").getImage();
	public Image cup = new ImageIcon("image/trophy_00.png").getImage();

	public Image headUp = new ImageIcon("image/head_up.png").getImage();
	public Image headDown = new ImageIcon("image/head_down.png").getImage();
	public Image headLeft = new ImageIcon("image/head_left.png").getImage();
	public Image headRight = new ImageIcon("image/head_right.png").getImage();

	public Image tailUp = new ImageIcon("image/tail_up.png").getImage();
	public Image tailDown = new ImageIcon("image/tail_down.png").getImage();
	public Image tailLeft = new ImageIcon("image/tail_left.png").getImage();
	public Image tailRight = new ImageIcon("image/tail_right.png").getImage();
	
	public Image bodyHorizontal = new ImageIcon("image/body_horizontal.png").getImage();
	public Image bodyVertical = new ImageIcon("image/body_vertical.png").getImage();
	
	public Image bodyBottomLeft = new ImageIcon("image/body_bottomleft.png").getImage();
	public Image bodyBottomRight = new ImageIcon("image/body_bottomright.png").getImage();
	public Image bodyTopLeft = new ImageIcon("image/body_topleft.png").getImage();
	public Image bodyTopRight = new ImageIcon("image/body_topright.png").getImage();
	
	private GameAsset() {
	}

	public static GameAsset getInstance() {
		if (instance == null)
			return instance = new GameAsset();
		return instance;
	}

}
