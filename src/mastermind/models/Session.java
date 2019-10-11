package mastermind.models;

import java.util.List;

import mastermind.types.Color;

public interface Session {

    void resume();

    void next();

    StateValue getValueState();

    public boolean undoable();

    public boolean redoable();

    public void undo();

    public void redo();

    public int getWidth();

    public void addProposedCombination(List<Color> colors);

    public boolean isLooser();

    public boolean isWinner();

    public int getAttempts();

    public List<Color> getColors(int position);

    public int getBlacks(int position);

    public int getWhites(int position);
}