package mastermind.models.dao;

public interface SessionDao {

    void save();

    void save(String name);

    void load(String name);

    String[] getGamesNames();

    boolean exists(String name);
}