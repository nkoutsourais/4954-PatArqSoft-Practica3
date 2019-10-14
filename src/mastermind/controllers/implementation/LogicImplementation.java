package mastermind.controllers.implementation;

import mastermind.controllers.Logic;
import mastermind.models.SessionImplementation;
import mastermind.models.StateValue;
import mastermind.models.dao.DaoType;
import mastermind.models.dao.SessionDao;
import mastermind.models.dao.SessionDaoPrototype;

public class LogicImplementation extends Logic {

	protected StartControllerImplementation startControllerImplementation;

	protected PlayControllerImplementation playControllerImplementation;

	protected ResumeControllerImplementation resumeControllerImplementation;

	protected SaveControllerImplementation saveControllerImplementation;

	public LogicImplementation(DaoType daoType) {
		this.session = new SessionImplementation();
		SessionDaoPrototype daoPrototype = new SessionDaoPrototype((SessionImplementation) this.session);
		SessionDao sessionImplementationDao = daoPrototype.getSessionImplementationDao(daoType);
		this.startControllerImplementation = new StartControllerImplementation(this.session, sessionImplementationDao);
		this.playControllerImplementation = new PlayControllerImplementation(this.session);
		this.saveControllerImplementation = new SaveControllerImplementation(this.session, sessionImplementationDao);
		this.resumeControllerImplementation = new ResumeControllerImplementation(this.session);
		this.controllers.put(StateValue.INITIAL, this.startControllerImplementation);
		this.controllers.put(StateValue.IN_GAME, this.playControllerImplementation);
		this.controllers.put(StateValue.FINAL, this.resumeControllerImplementation);
		this.controllers.put(StateValue.SAVE, this.saveControllerImplementation);
		this.controllers.put(StateValue.EXIT, null);
	}
}