package mastermind.controllers.implementation;

import mastermind.controllers.Logic;
import mastermind.models.SessionImplementation;
import mastermind.models.StateValue;

public class LogicImplementation extends Logic {

    public LogicImplementation() {
		this.session = new SessionImplementation();
		this.controllers.put(StateValue.INITIAL, new StartControllerImplementation(this.session));
		this.controllers.put(StateValue.IN_GAME, new PlayControllerImplementation(this.session));
		this.controllers.put(StateValue.FINAL, new ResumeControllerImplementation(this.session));
		this.controllers.put(StateValue.EXIT, null);
	}
}