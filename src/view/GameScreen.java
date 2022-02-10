package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.IController;
import defaul.GameConfig;

public class GameScreen extends JFrame {
	IController controller;
	JPanel optPn;
	JPanel gamePn;
	JButton soundBtn;
	JButton exitBtn;
	JLabel pointLb;

	public GameScreen(IController controler) {
		super(GameConfig.name);
		this.controller = controler;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(new Dimension(GameConfig.frameWidth, GameConfig.frameHeight + 70));
		init();
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void init() {
		Font font = new Font("Bushcraft", Font.BOLD, 16);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		optPn = new JPanel();
		optPn.setBackground(GameConfig.backRoundNorth);
		optPn.setPreferredSize(new Dimension(GameConfig.frameWidth, 70));
		optPn.setLayout(new BorderLayout());

		pointLb = new JLabel(new ImageIcon("image/apple.png"));
		pointLb.setFont(font);
		pointLb.setForeground(Color.white);
		pointLb.setText("0");
		optPn.add(pointLb, BorderLayout.WEST);

		gamePn = new GamePanel(controller);
		getContentPane().add(optPn);
		getContentPane().add(gamePn);
	}

}
