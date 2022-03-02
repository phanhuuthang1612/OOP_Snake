package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import config.GameConfig;
import config.GameEvent;
import config.GameAsset;
import control.IController;
import model.IModel;

public class GameScreen extends JFrame implements IView, Observer {
	private IController controller;
	private JPanel optPn;
	private GamePanel gamePn;
	private JButton soundBtn;
	private JButton exitBtn;
	private JLabel pointLb, highScoreLb, levelLb;
	private IModel model;
	private boolean isReady;

	public GameScreen(IController controler) {
		super(GameConfig.name);
		this.controller = controler;
		this.model = controler.getModel();
		((Observable) this.model).addObserver(this);
		init();
		pack();
		setFocusable(true);
		requestFocus();
		addKeyListener(keyListener());
		setLocationRelativeTo(null);
		setVisible(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

	}

	private void init() {
		Font font = new Font("Bushcraft", Font.BOLD, 20);
		setLayout(new BorderLayout());
		optPn = new JPanel();
		optPn.setBackground(GameConfig.backRoundNorth);
		optPn.setPreferredSize(new Dimension(GameConfig.frameWidth, 70));
		optPn.setLayout(new BorderLayout());

		JPanel pointPn = new JPanel();
		pointPn.setOpaque(false);
		pointLb = new JLabel(new ImageIcon(GameAsset.getInstance().apple));
		pointLb.setFont(font);
		pointLb.setForeground(Color.white);
		pointLb.setText("0");
		pointPn.add(pointLb);

		Image cup = GameAsset.getInstance().cup;
		Image imageFit = cup.getScaledInstance(40, 40, Image.SCALE_SMOOTH);

		highScoreLb = new JLabel(new ImageIcon(imageFit));
		highScoreLb.setFont(font);
		highScoreLb.setForeground(Color.white);
		highScoreLb.setText("0");
		pointPn.add(highScoreLb);
		font = new Font("Bushcraft", Font.BOLD, 24);
		levelLb = new JLabel();
		levelLb.setFont(font);
		levelLb.setForeground(Color.white);
		levelLb.setText("      Level : " + model.getLevel());
		pointPn.add(levelLb);

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
		exitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.back();

			}
		});

		btnPn.add(exitBtn);
		optPn.add(btnPn, BorderLayout.EAST);

		gamePn = new GamePanel(controller);
		gamePn.setPreferredSize(new Dimension(GameConfig.frameWidth, GameConfig.frameHeight));

		add(optPn, BorderLayout.NORTH);
		add(gamePn, BorderLayout.EAST);
	}

	private void showGameOverDialog() {
		Object[] options = { "RETRY", "BACK" };
		int op = JOptionPane.showOptionDialog(null, "Your score is " + model.getPoint(), "Warning",
				JOptionPane.DEFAULT_OPTION, JOptionPane.YES_NO_OPTION, null, options, options[0]);
		if (op == -1 || op == 1) {
			controller.newGame();
			controller.back();
		} else {
			isReady = false;
			controller.newGame();
		}
	}

	@Override
	public void newGame() {
		levelLb.setText("      Level : " + model.getLevel());
		isReady = false;
		setVisible(true);
		setFocusable(true);
		requestFocus();
	}

	@Override
	public void lose() {
		showGameOverDialog();
	}

	@Override
	public void resume() {
		isReady = false;

		setVisible(true);
		setFocusable(true);
		requestFocus();
	}

	@Override
	public void back() {
		setVisible(false);
	}

	@Override
	public void update(Observable o, Object event) {
		if (event.equals(GameEvent.RENDER))
			gamePn.repaint();
		else if (event.equals(GameEvent.UPDATE_POINT))
			pointLb.setText(model.getPoint() + "");
		else if (event.equals(GameEvent.UPDATE_HIGHTSCORE))
			highScoreLb.setText(model.getPoint() + "");
		else if (event.equals(GameEvent.NEW_GAME)) {
			pointLb.setText(model.getPoint() + "");
			gamePn.repaint();
		} else if (event.equals(GameEvent.GAME_OVER)) {
			gamePn.repaint();
			controller.lose();
		}
	}

	private KeyListener keyListener() {
		return new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (!isReady) {
					isReady = true;
					controller.start();					
				}

				if (keyCode == 37)
					controller.moveLeft();
				if (keyCode == 38)
					controller.moveUp();
				if (keyCode == 39)
					controller.moveRight();
				if (keyCode == 40)
					controller.moveDown();

			}
		};
	}

}
