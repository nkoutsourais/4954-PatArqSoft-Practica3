package mastermind;

import mastermind.controllers.AcceptorController;
import mastermind.controllers.Logic;
import mastermind.views.View;
import mastermind.views.console.ConsoleView;

public abstract class Mastermind {

	private Logic logic;
	private View view;

	protected Mastermind() {
		this.view = new ConsoleView();
	}

	protected abstract Logic createLogic();

	protected void play() {
		this.logic = createLogic();
		AcceptorController controller;
		do {
			controller = this.logic.getController();
			if (controller != null) {
				this.view.interact(controller);
			}
		} while (controller != null);
	}
}