package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.GameConfig;
import control.IController;
import model.IModel;

public class GameScreen extends JFrame implements IView, Observer {
	private IController controller;
	private JPanel optPn;
	private GamePanel gamePn;
	private JButton soundBtn;
	private JButton exitBtn;
	private JLabel pointLb, highScoreLb;
	private IModel model;
	

	public GameScreen(IController controler) {
		super(GameConfig.name);
		this.controller = controler;
		this.model = controler.getModel();
		((Observable) this.model).addObserver(this);
		init();
		pack();
		setFocusable(true);
		addKeyListener(keyListener());
		setLocationRelativeTo(null);
		setVisible(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

	}

	private void init() {
		Font font = new Font("Bushcraft", Font.BOLD, 16);
		setLayout(new BorderLayout());
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
		exitBtn = new JButton(iconBt);
		exitBtn.setBorder(null);
		exitBtn.setFocusPainted(false);
		exitBtn.setContentAreaFilled(false);
		btnPn.add(exitBtn);
		optPn.add(btnPn, BorderLayout.EAST);

		gamePn = new GamePanel(controller);
		gamePn.setPreferredSize(new Dimension(GameConfig.frameWidth, GameConfig.frameHeight));

		add(optPn, BorderLayout.NORTH);
		add(gamePn, BorderLayout.EAST);
	}

	@Override
	public void newGame() {
		controller.newGame();
	}

	@Override
	public void start() {
		controller.start();

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

	@Override
	public void update(Observable o, Object arg) {
		gamePn.repaint();
		System.out.println("repaint");

	}

	private KeyListener keyListener() {
		return new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				controller.start();
			}
		};
	}

}
