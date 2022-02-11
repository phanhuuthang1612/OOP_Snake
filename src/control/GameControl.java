package control;

import model.Broad;
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
	public void start() {
		gameScreen.newGame();
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
		menuScreen.newGame();
	}

	@Override
	public void resume() {
		model.pause();
		menuScreen.newGame();
	}

	@Override
	public void setLevel(int level) {
		model.setLevel(level);

	}

	@Override
	public IModel getModel() {
		return this.model;
	}

}
