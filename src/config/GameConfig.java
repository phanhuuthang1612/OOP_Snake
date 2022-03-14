package config;

import java.awt.Color;

public class GameConfig {
	public static int frameWidth = 720; // chiều rộng 
	public static int frameHeight = 480; // chiều dài
	public static int size = 30; // 1 ô
	public static int col = 720 / 30; // số cột
	public static int row = 480 / 30; // số hàng
	public static Color backRoundNorth = new Color(74, 117, 44);
	public static Color backroundWall = new Color(87, 138, 52);
	public static Color backroundBroad1 = new Color(167, 217, 72);
	public static Color backroundBroad2 = new Color(142, 204, 57);
	public static Color headColor = new Color(255, 255, 0);
	public static Color bodyColor = new Color(80, 118, 249);
	public static String name = "Game Snake";
}
