package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import config.GameConfig;
import control.IController;
import model.IModel;

public class GamePanel extends JPanel {
	IController controller;
	IModel model;

	public GamePanel(IController controller) {
		super();
		this.controller = controller;
		this.model = controller.getModel();
	
	}

	@Override
	public void paint(Graphics g) {
		model.draw(g);

	}
}
