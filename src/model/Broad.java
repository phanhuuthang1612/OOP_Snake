package model;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Random;

import javax.swing.Timer;

import config.GameConfig;
import config.GameEvent;

public class Broad extends Observable implements IModel {
	private Apple apple;
	private Snake snake;
	private Wall wall;
	private int highScore;
	private int level;
	private int point;
	private Timer timer;
	private int speed;
	private boolean isReady;

	public Broad(Apple apple, model.Snake snake, Wall wall) {
		this.apple = apple;
		this.snake = snake;
		this.wall = wall;

		highScore = 0;
		speed = 700;

		timer = new Timer(speed, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				snake.move();
				if (snake.hitWall(wall) || snake.isEatSelf()) {
					setChanged();
					notifyObservers(GameEvent.GAME_OVER);
				}
				if (snake.isEatApple(apple)) {
					point++;
					newApple();
					if (point > highScore) {
						highScore = point;
						setChanged();
						notifyObservers(GameEvent.UPDATE_HIGHTSCORE);
					}
					setChanged();
					notifyObservers(GameEvent.UPDATE_POINT);
				}

				setChanged();
				notifyObservers(GameEvent.RENDER);
			}
		});
		newGame();
	}

	@Override
	public void newGame() {
		point = 0;
		snake.newSnake();
		newApple();
		isReady = false;
		timer.stop();
		setChanged();
		notifyObservers(GameEvent.NEW_GAME);
	}

	private void newApple() {
		Point p;
		Random rd = new Random();
		do {
			int x = rd.nextInt(GameConfig.col - 2) + 1;
			int y = rd.nextInt(GameConfig.col - 2) + 1;
			p = new Point(x, y);
		} while (snake.isInSnake(p) || wall.isInWall(p));
		apple.setLocation(p);
	}

	@Override
	public void start() {
		timer.start();
		isReady = true;
	}

	@Override
	public void pause() {
		timer.stop();
	}

	@Override
	public void setLevel(int level) {
		this.level = level;
		if (level == 1)
			speed = 700;
		else if (level == 2)
			speed = 500;
		else if (level == 3)
			speed = 400;
		else if (level == 4)
			speed = 300;
		else if (level == 5)
			speed = 200;
		timer.setDelay(speed);
	}

	@Override
	public int getPoint() {
		return this.point;
	}

	@Override
	public int getLevel() {
		return this.level;
	}

	private AlphaComposite makeComposite(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return (AlphaComposite.getInstance(type, alpha));
	}

	public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
		// Get the FontMetrics
		FontMetrics metrics = g.getFontMetrics(font);
		// Determine the X coordinate for the text
		int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
		// Determine the Y coordinate for the text (note we add the ascent, as in java
		// 2d 0 is top of the screen)
		int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
		// Set the font
		g.setFont(font);
		// Draw the String
		g.drawString(text, x, y);
	}

	@Override
	public void draw(Graphics g) {
		wall.draw(g);
		apple.draw(g);
		snake.draw(g);
		if (!isReady) {
			Graphics2D g2d = (Graphics2D) g;
			Composite originalComposite = g2d.getComposite();
			g2d.setPaint(Color.gray);
			g2d.setComposite(makeComposite(5 * 0.1F));
			Rectangle fullRect = new Rectangle(GameConfig.frameWidth, GameConfig.frameHeight);
			g2d.fill(fullRect);
			g2d.setComposite(makeComposite(1));
			Font font = new Font("Bushcraft", Font.BOLD, 24);
			g.setColor(Color.yellow);
			drawCenteredString(g, "Press any to start", fullRect, font);
		}

	}

	@Override
	public void moveLeft() {
		snake.changeArchor(Snake.LEFT);

	}

	@Override
	public void moveRight() {
		snake.changeArchor(Snake.RIGHT);
	}

	@Override
	public void moveUp() {
		snake.changeArchor(Snake.UP);
	}

	@Override
	public void moveDown() {
		snake.changeArchor(Snake.DOWN);
	}

	@Override
	public int getHighScore() {
		return this.highScore;
	}

}
