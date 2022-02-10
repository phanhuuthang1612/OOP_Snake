package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.IController;
import defaul.GameConfig;

public class MenuScreen extends JFrame {
	IController control;
	JPanel btnPn;
	JButton newGameBtn, resumeBtn, highScoreBtn, quitBtn;

	public MenuScreen(IController control) {
		super(GameConfig.name);
		this.control = control;
		init();
	}

	private void init() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		setContentPane(new JLabel(new ImageIcon("image\\background.png")));
		getContentPane().setLayout(new FlowLayout());
		addButtons();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void addButtons() {
		Font font = new Font("Bushcraft", Font.BOLD, 30);
		btnPn = new JPanel();
		btnPn.setSize(new Dimension(200, 200));
		btnPn.setLayout(new BoxLayout(btnPn, BoxLayout.Y_AXIS));

		newGameBtn = new JButton("New Game");
		resumeBtn = new JButton("Resume");
		highScoreBtn = new JButton("HighScore");
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

		highScoreBtn.setFont(font);
		highScoreBtn.setForeground(Color.white);
		highScoreBtn.setBorder(null);
		highScoreBtn.setFocusPainted(false);
		highScoreBtn.setContentAreaFilled(false);
		highScoreBtn.setAlignmentX(Container.CENTER_ALIGNMENT);
		highScoreBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				highScoreBtn.setForeground(Color.white);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				highScoreBtn.setForeground(Color.yellow);

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

			}
		});

		btnPn.add(Box.createVerticalStrut(240));
		btnPn.add(newGameBtn);
		btnPn.add(Box.createVerticalStrut(30));
		btnPn.add(resumeBtn);
		btnPn.add(Box.createVerticalStrut(30));
		btnPn.add(highScoreBtn);
		btnPn.add(Box.createVerticalStrut(30));
		btnPn.add(quitBtn);
		btnPn.setOpaque(false);
		getContentPane().add(btnPn);
	}
}
