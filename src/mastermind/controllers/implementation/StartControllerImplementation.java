package mastermind.controllers.implementation;

import mastermind.controllers.StartController;
import mastermind.models.Session;
import mastermind.models.SessionImplementation;
import mastermind.models.dao.SessionImplementationDao;

public class StartControllerImplementation extends StartController {

	private final SessionImplementationDao sessionImplementationDao;

	public StartControllerImplementation(Session session, SessionImplementationDao sessionImplementationDao) {
		super(session);
		this.sessionImplementationDao = sessionImplementationDao;
	}

	@Override
	public void start() {
		((SessionImplementation) this.session).setName(null);
		((SessionImplementation) this.session).next();
	}

	@Override
	public void start(String name) {
		this.sessionImplementationDao.load(name);
	}

	@Override
	public String[] getGamesNames() {
		return this.sessionImplementationDao.getGamesNames();
	}
}