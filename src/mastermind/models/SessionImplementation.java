package mastermind.models;

import java.util.List;

import mastermind.types.Color;
import mastermind.utils.Registry;

public class SessionImplementation implements Session {
    
    private Game game;

    private State state;

    private Registry registry;

    private String name;

    public SessionImplementation() {
        this.game = new Game();
        this.state = new State();
        this.registry = new Registry(this.game);
    }

    public Game getGame() {
        return this.game;
    }

    public void resume() {
        this.game.clear();
        this.state.reset();
        this.registry.reset();
    }

    public void next() {
        this.state.next();
    }

    public StateValue getValueState() {
        return this.state.getValueState();
    }

    public void setStateValue(StateValue stateValue) {
        this.state.setValueState(stateValue);
    }

    public void resetRegistry() {
        this.registry.reset();
    }

    public boolean hasName() {
        return this.name != null;
    }

    public boolean undoable() {
        return this.registry.undoable();
    }

    public boolean redoable() {
        return this.registry.redoable();
    }

    public void undo() {
        this.registry.undo(this.game);
    }

    public void redo() {
        this.registry.redo(this.game);
    }

    public int getWidth() {
        return this.game.getWidth();
    }

    public void addProposedCombination(List<Color> colors) {
        this.game.addProposedCombination(colors);
        this.registry.registry();
    }

    public boolean isGameFinished() {
        return isLooser() || isWinner();
    }

    public boolean isLooser() {
        return this.game.isLooser();
    }

    public boolean isWinner() {
        return this.game.isWinner();
    }

    public int getAttempts() {
        return this.game.getAttempts();
    }

    public List<Color> getColors(int position) {
        return this.game.getColors(position);
    }

    public int getBlacks(int position) {
        return this.game.getBlacks(position);
    }

    public int getWhites(int position) {
        return this.game.getWhites(position);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}