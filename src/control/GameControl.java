package control;

import model.IModel;
import view.GameScreen;
import view.IView;
import view.MenuScreen;

public class GameControl implements IController {

	private IModel model;

	private IView menuScreen;
	private IView gameScreen;

	public GameControl(IModel model) {
		this.model = model;
		menuScreen = new MenuScreen(this);
		gameScreen = new GameScreen(this);

	}

	@Override
	public void newGame() {
		model.newGame();
		gameScreen.newGame();
		menuScreen.newGame();
	}

	@Override
	public void start() {
		model.start();
	}

	@Override
	public void moveUp() {
		model.moveUp();
	}

	@Override
	public void moveLeft() {
		model.moveLeft();

	}

	@Override
	public void moveRight() {
		model.moveRight();

	}

	@Override
	public void moveDown() {
		model.moveDown();

	}

	@Override
	public void pause() {
		model.pause();
	}

	@Override
	public void lose() {
		model.pause();
		gameScreen.lose();
	
	}

	@Override
	public void resume() {
		model.pause();
		menuScreen.resume();
		gameScreen.resume();
	}

	@Override
	public void setLevel(int level) {
		model.setLevel(level);
	}

	@Override
	public IModel getModel() {
		return this.model;
	}

	@Override
	public void back() {
		model.pause();
		gameScreen.back();
		menuScreen.back();
	}

}
