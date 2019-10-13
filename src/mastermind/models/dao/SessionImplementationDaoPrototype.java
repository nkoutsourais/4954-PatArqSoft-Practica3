package mastermind.models.dao;

import java.util.HashMap;
import java.util.Map;

import mastermind.models.SessionImplementation;
import mastermind.models.dao.file.SessionImplementationFileDao;

public class SessionImplementationDaoPrototype {

    private Map<DaoType, SessionImplementationDao> sessionDaoMap;

    public SessionImplementationDaoPrototype(SessionImplementation sessionImplementation) {
        sessionDaoMap = new HashMap<>();
        this.add(DaoType.FILE, new SessionImplementationFileDao(sessionImplementation));
        //this.add(DaoType.DB, new SessionImplementationDbDao(sessionImplementation));
    }

    private void add(DaoType daoType, SessionImplementationDao sessionDao) {
        this.sessionDaoMap.put(daoType, sessionDao);
    }

    public SessionImplementationDao getSessionImplementationDao(DaoType daoType) {
        return this.sessionDaoMap.get(daoType);
    }
}