package mastermind.models.dao.file;

import mastermind.models.SessionImplementation;
import mastermind.models.StateValue;
import mastermind.models.dao.SessionImplementationDao;

import java.io.*;

public class SessionImplementationFileDao implements SessionImplementationDao {

    public static final String EXTENSION = ".mastermind";

    public static final String DIRECTORY = System.getProperty("user.dir") + "/partidas";

    private static File directory;

    static {
        SessionImplementationFileDao.directory = new File(SessionImplementationFileDao.DIRECTORY);
        if (!SessionImplementationFileDao.directory.exists()) {
            SessionImplementationFileDao.directory.mkdir();
        }
    }

    private final SessionImplementation sessionImplementation;

    private final GameFileDao gameDao;

    public SessionImplementationFileDao(SessionImplementation sessionImplementation) {
        this.sessionImplementation = sessionImplementation;
        this.gameDao = new GameFileDao(sessionImplementation.getGame());
    }

    public void save() {
        this.save(this.sessionImplementation.getName());
    }

    public void save(String name) {
        if (!name.endsWith(SessionImplementationFileDao.EXTENSION)) {
            name = name + SessionImplementationFileDao.EXTENSION;
        }
        File file = new File(SessionImplementationFileDao.directory, name);
        try {
            FileWriter fileWriter = new FileWriter(file);
            this.gameDao.save(fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String name) {
        this.sessionImplementation.setName(name);
        File file = new File(SessionImplementationFileDao.directory, name);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            this.gameDao.load(bufferedReader);
            this.sessionImplementation.resetRegistry();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sessionImplementation.setStateValue(StateValue.IN_GAME);
        if (this.sessionImplementation.isGameFinished()) {
            this.sessionImplementation.setStateValue(StateValue.FINAL);
        }
    }

    public String[] getGamesNames() {
        return SessionImplementationFileDao.directory.list();
    }

    public boolean exists(String name) {
        for (String auxName : this.getGamesNames()) {
            if (auxName.equals(name + SessionImplementationFileDao.EXTENSION)) {
                return true;
            }
        }
        return false;
    }
}