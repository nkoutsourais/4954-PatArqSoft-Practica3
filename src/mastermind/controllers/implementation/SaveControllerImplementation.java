package mastermind.controllers.implementation;

import mastermind.controllers.SaveController;
import mastermind.models.dao.SessionImplementationDao;
import mastermind.models.Session;
import mastermind.models.SessionImplementation;

public class SaveControllerImplementation extends SaveController {

    private final SessionImplementationDao sessionImplementationDAO;

    SaveControllerImplementation(Session session, SessionImplementationDao sessionImplementationDao) {
        super(session);
        this.sessionImplementationDAO = sessionImplementationDao;
    }

    @Override
    public void save(String name) {
        this.sessionImplementationDAO.save(name);
    }

    @Override
    public void save() {
        this.sessionImplementationDAO.save();
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
        return this.sessionImplementationDAO.exists(name);
    }
}