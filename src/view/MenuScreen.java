package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import config.GameConfig;
import config.GameEvent;
import config.GameAsset;
import control.IController;
import model.IModel;

public class MenuScreen extends JFrame implements IView, Observer {
	private IController control;
	private JButton newGameBtn, resumeBtn, quitBtn;
	private JLabel highScoreLb;
	private IModel model;

	public MenuScreen(IController control) {
		super(GameConfig.name);
		this.control = control;
		this.model = control.getModel();
		((Observable) model).addObserver(this);

		init();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		setSize(new Dimension(GameConfig.frameWidth, GameConfig.frameHeight));
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void init() {
		setContentPane(new JLabel(new ImageIcon(GameAsset.getInstance().background)));
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		addLabel();
		addButtons();
	}

	private void addLabel() {
		Font font = new Font("Bushcraft", Font.BOLD, 24);
		add(Box.createVerticalStrut(200));
		highScoreLb = new JLabel("HighScore : " + model.getHighScore());
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
				showSeleteLevel();
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
				control.resume();
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

	private void showSeleteLevel() {
		Object[] possibilities = { "Level 1", "Level 2", "Level 3", "Level 4", "Level 5" };
		String s = (String) JOptionPane.showInputDialog(this, "Select your level", "Level", JOptionPane.PLAIN_MESSAGE,
				null, possibilities, "Level 1");
		if ((s != null) && (s.length() > 0)) {
			if (s.equals("Level 1"))
				control.setLevel(1);
			else if (s.equals("Level 2"))
				control.setLevel(2);
			else if (s.equals("Level 3"))
				control.setLevel(3);
			else if (s.equals("Level 4"))
				control.setLevel(4);
			else if (s.equals("Level 5"))
				control.setLevel(5);
			control.newGame();
			return;
		}
	}

	@Override
	public void newGame() {
		setVisible(false);
	}

	@Override
	public void lose() {

	}

	@Override
	public void resume() {
		setVisible(false);
	}

	@Override
	public void back() {
		setVisible(true);

	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg.equals(GameEvent.UPDATE_HIGHTSCORE))
			highScoreLb.setText("HighScore : " + model.getHighScore());
	}
}
