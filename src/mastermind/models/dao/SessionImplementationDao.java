package mastermind.models.dao;

public interface SessionImplementationDao {

    void save();

    void save(String name);

    void load(String name);

    String[] getGamesNames();

    boolean exists(String name);
}