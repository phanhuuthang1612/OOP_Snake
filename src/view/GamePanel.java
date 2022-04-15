package view;

import java.awt.Graphics;

import javax.swing.JPanel;

import control.IController;
import model.IModel;

public class GamePanel extends JPanel {
	private IModel model;

	public GamePanel(IController controller) {
		super();
		this.model = controller.getModel();

	}

	@Override
	public void paint(Graphics g) {
		model.draw(g);
	}
}
