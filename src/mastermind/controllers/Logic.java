package mastermind.controllers;

import java.util.HashMap;
import java.util.Map;

import mastermind.controllers.implementation.PlayControllerImplementation;
import mastermind.controllers.implementation.ResumeControllerImplementation;
import mastermind.controllers.implementation.StartControllerImplementation;
import mastermind.models.Session;
import mastermind.models.SessionImplementation;
import mastermind.models.StateValue;

public abstract class Logic {

	protected Session session;

	protected Map<StateValue, AcceptorController> controllers;

	public Logic() {
		this.controllers = new HashMap<StateValue, AcceptorController>();
		this.session = new SessionImplementation();
		this.controllers.put(StateValue.INITIAL, new StartControllerImplementation(this.session));
		this.controllers.put(StateValue.IN_GAME, new PlayControllerImplementation(this.session));
		this.controllers.put(StateValue.FINAL, new ResumeControllerImplementation(this.session));
		this.controllers.put(StateValue.EXIT, null);
	}

	public AcceptorController getController() {
		return this.controllers.get(this.session.getValueState());
	}
}