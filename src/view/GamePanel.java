package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import control.IController;
import defaul.GameConfig;

public class GamePanel extends JPanel {
	IController controller;

	public GamePanel(IController controller) {
		super();
		this.controller = controller;
		init();
	}

	private void init() {
		setPreferredSize(new Dimension(GameConfig.frameWidth, GameConfig.frameHeight));
		setBackground(GameConfig.backroundBoard);
	}

	@Override
	public void paint(Graphics g) {
		
	}
}
