package main;

import control.GameControl;
import control.IController;
import view.GameScreen;
import view.MenuScreen;

public class Main {
	public static void main(String[] args) {
		IController gameControl = new GameControl();
		new GameScreen(gameControl);
	}
}
