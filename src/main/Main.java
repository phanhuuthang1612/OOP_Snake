package main;

import control.GameControl;
import control.IController;
import model.Apple;
import model.Broad;
import model.IModel;
import model.Snake;
import model.Wall;
import view.GameScreen;

public class Main {
	public static void main(String[] args) {

		Wall wall = new Wall();
		Snake snake = new Snake();
		Apple apple = new Apple();
		IModel broad = new Broad(apple, snake, wall);
		IController gameControl = new GameControl(broad);
	}
}
