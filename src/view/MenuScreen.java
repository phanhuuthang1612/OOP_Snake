package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.GameConfig;
import control.IController;
import model.IModel;

public class MenuScreen extends JFrame implements IView {
	private IController control;
	private JPanel btnPn;
	private JButton newGameBtn, resumeBtn, quitBtn;
	private JLabel highScoreLb;
	private ImageIcon image;
	private IModel model;

	public MenuScreen(IController control) {
		super(GameConfig.name);
		this.control = control;
		this.model = control.getModel();
		image = new ImageIcon("image//background.png");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setContentPane(new JLabel(image));
		setSize(new Dimension(GameConfig.frameWidth, GameConfig.frameHeight));
		init();
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void init() {
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		addLabel();
		addButtons();
		setPreferredSize(new Dimension(GameConfig.frameWidth, GameConfig.frameHeight));
	}

	private void addLabel() {
		Font font = new Font("Bushcraft", Font.BOLD, 24);
		add(Box.createVerticalStrut(200));
		highScoreLb = new JLabel("HighScore :" + model.getHighScore());
		highScoreLb.setFont(font);
		highScoreLb.setForeground(Color.yellow);
		add(highScoreLb);
		highScoreLb.setAlignmentX(Container.CENTER_ALIGNMENT);
		add(Box.createVerticalStrut(30));
	}

	private void addButtons() {
		Font font = new Font("Bushcraft", Font.BOLD, 30);

		newGameBtn = new JButton("New Game");
		resumeBtn = new JButton("Resume");
		quitBtn = new JButton("Quit");

		newGameBtn.setFont(font);
		newGameBtn.setForeground(Color.white);
		newGameBtn.setBorder(null);
		newGameBtn.setFocusPainted(false);
		newGameBtn.setContentAreaFilled(false);
		newGameBtn.setAlignmentX(Container.CENTER_ALIGNMENT);
		newGameBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				newGameBtn.setForeground(Color.white);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				newGameBtn.setForeground(Color.yellow);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				newGame();
			}
		});

		resumeBtn.setFont(font);
		resumeBtn.setForeground(Color.white);
		resumeBtn.setBorder(null);
		resumeBtn.setFocusPainted(false);
		resumeBtn.setContentAreaFilled(false);
		resumeBtn.setAlignmentX(Container.CENTER_ALIGNMENT);
		resumeBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				resumeBtn.setForeground(Color.white);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				resumeBtn.setForeground(Color.yellow);

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		quitBtn.setFont(font);
		quitBtn.setForeground(Color.white);
		quitBtn.setBorder(null);
		quitBtn.setFocusPainted(false);
		quitBtn.setContentAreaFilled(false);
		quitBtn.setAlignmentX(Container.CENTER_ALIGNMENT);
		quitBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				quitBtn.setForeground(Color.white);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				quitBtn.setForeground(Color.yellow);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		add(newGameBtn);
		add(Box.createVerticalStrut(30));
		add(resumeBtn);
		add(Box.createVerticalStrut(30));
		add(quitBtn);

	}

	@Override
	public void newGame() {
		setVisible(false);
		control.newGame();

	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {

	}

	@Override
	public void lose() {
		setVisible(true);

	}

	@Override
	public void resume() {
		setVisible(false);

	}
}
