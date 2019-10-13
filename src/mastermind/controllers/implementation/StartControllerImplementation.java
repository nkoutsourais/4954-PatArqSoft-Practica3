package mastermind.controllers.implementation;

import mastermind.controllers.StartController;
import mastermind.models.Session;
import mastermind.models.SessionImplementation;
import mastermind.models.dao.SessionDao;

public class StartControllerImplementation extends StartController {

	private final SessionDao sessionDao;

	public StartControllerImplementation(Session session, SessionDao sessionImplementationDao) {
		super(session);
		this.sessionDao = sessionImplementationDao;
	}

	@Override
	public void start() {
		((SessionImplementation) this.session).setName(null);
		((SessionImplementation) this.session).next();
	}

	@Override
	public void start(String name) {
		this.sessionDao.load(name);
	}

	@Override
	public String[] getGamesNames() {
		return this.sessionDao.getGamesNames();
	}
}