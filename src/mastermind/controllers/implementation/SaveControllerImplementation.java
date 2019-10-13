package mastermind.controllers.implementation;

import mastermind.controllers.SaveController;
import mastermind.models.dao.SessionDao;
import mastermind.models.Session;
import mastermind.models.SessionImplementation;

public class SaveControllerImplementation extends SaveController {

    private final SessionDao sessionDao;

    SaveControllerImplementation(Session session, SessionDao sessionImplementationDao) {
        super(session);
        this.sessionDao = sessionImplementationDao;
    }

    @Override
    public void save(String name) {
        this.sessionDao.save(name);
    }

    @Override
    public void save() {
        this.sessionDao.save();
    }

    @Override
    public void next() {
        ((SessionImplementation) this.session).next();
    }

    @Override
    public boolean hasName() {
        return ((SessionImplementation) this.session).hasName();
    }

    @Override
    public boolean exists(String name) {
        return this.sessionDao.exists(name);
    }
}