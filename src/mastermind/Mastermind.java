package mastermind;

import mastermind.controllers.AcceptorController;
import mastermind.controllers.Logic;
import mastermind.views.View;
import mastermind.views.console.ConsoleView;

public abstract class Mastermind {

	private View view;

	protected Mastermind() {
		this.view = new ConsoleView();
	}

	protected void play(Logic logic) {
		AcceptorController controller;
		do {
			controller = logic.getController();
			if (controller != null) {
				this.view.interact(controller);
			}
		} while (controller != null);
	}
}