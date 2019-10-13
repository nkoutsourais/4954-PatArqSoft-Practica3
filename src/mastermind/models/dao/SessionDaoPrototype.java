package mastermind.models.dao;

import java.util.HashMap;
import java.util.Map;

import mastermind.models.SessionImplementation;
import mastermind.models.dao.file.SessionImplementationFileDao;

public class SessionDaoPrototype {

    private Map<DaoType, SessionDao> sessionDaoMap;

    public SessionDaoPrototype(SessionImplementation sessionImplementation) {
        sessionDaoMap = new HashMap<>();
        this.add(DaoType.FILE, new SessionImplementationFileDao(sessionImplementation));
        //this.add(DaoType.DB, new SessionImplementationDbDao(sessionImplementation));
    }

    private void add(DaoType daoType, SessionDao sessionDao) {
        this.sessionDaoMap.put(daoType, sessionDao);
    }

    public SessionDao getSessionImplementationDao(DaoType daoType) {
        return this.sessionDaoMap.get(daoType);
    }
}