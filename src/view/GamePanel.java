package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import control.IController;
import defaul.GameConfig;
import model.IModel;

public class GamePanel extends JPanel {
	IController controller;
	IModel model;

	public GamePanel(IController controller) {
		super();
		this.controller = controller;
		this.model = controller.getModel();
		init();
	}

	private void init() {
		setPreferredSize(new Dimension(GameConfig.frameWidth, GameConfig.frameHeight));
		setBackground(GameConfig.backroundBoard);
	}

	@Override
	public void paint(Graphics g) {
		model.draw(g);
	}
}
