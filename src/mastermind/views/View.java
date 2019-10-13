package mastermind.views;

import mastermind.controllers.AcceptorController;
import mastermind.controllers.ControllersVisitor;

public abstract class View implements ControllersVisitor {

	public void interact(AcceptorController controller) {
		controller.accept(this);
	}
}