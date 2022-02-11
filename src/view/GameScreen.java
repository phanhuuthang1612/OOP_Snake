package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.IController;
import defaul.GameConfig;
import model.IModel;

public class GameScreen extends JFrame implements IView {
	private IController controller;
	private JPanel optPn;
	private JPanel gamePn;
	private JButton soundBtn;
	private JButton exitBtn;
	private JLabel pointLb, highScoreLb;
	private IModel model;

	public GameScreen(IController controler) {
		super(GameConfig.name);
		this.controller = controler;
		this.model = model;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(new Dimension(GameConfig.frameWidth, GameConfig.frameHeight + 70));
		init();
		setLocationRelativeTo(null);
		setVisible(false);

	}

	private void init() {
		Font font = new Font("Bushcraft", Font.BOLD, 16);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		optPn = new JPanel();
		optPn.setBackground(GameConfig.backRoundNorth);
		optPn.setPreferredSize(new Dimension(GameConfig.frameWidth, 70));
		optPn.setLayout(new BorderLayout());

		JPanel pointPn = new JPanel();
		pointPn.setOpaque(false);
		pointLb = new JLabel(new ImageIcon("image/apple.png"));
		pointLb.setFont(font);
		pointLb.setForeground(Color.white);
		pointLb.setText("0");
		pointPn.add(pointLb);

		ImageIcon icon = new ImageIcon("image/trophy_00.png");
		Image imageFit = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		icon = new ImageIcon(imageFit);
		highScoreLb = new JLabel(icon);
		highScoreLb.setFont(font);
		highScoreLb.setForeground(Color.white);
		highScoreLb.setText("0");
		pointPn.add(highScoreLb);
		optPn.add(pointPn, BorderLayout.WEST);

		JPanel btnPn = new JPanel();
		btnPn.setOpaque(false);
		ImageIcon iconBt = new ImageIcon("image/close.png");
		Image imageFitBt = iconBt.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		iconBt = new ImageIcon(imageFitBt);
		soundBtn = new JButton(iconBt);
		soundBtn.setBorder(null);
		soundBtn.setFocusPainted(false);
		soundBtn.setContentAreaFilled(false);
		btnPn.add(soundBtn);
		optPn.add(btnPn, BorderLayout.EAST);
		
		gamePn = new GamePanel(controller);
		getContentPane().add(optPn);
		getContentPane().add(gamePn);
	}

	@Override
	public void newGame() {
		setVisible(true);
	}

	@Override
	public void pause() {
		controller.pause();
	}

	@Override
	public void lose() {
		setVisible(false);
		controller.lose();
	}

	@Override
	public void resume() {
		controller.resume();

	}

}
