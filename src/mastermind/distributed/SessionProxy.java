package mastermind.distributed;

import java.util.List;

import mastermind.distributed.dispatchers.TCPIP;
import mastermind.models.Session;
import mastermind.models.StateValue;
import mastermind.types.Color;

public class SessionProxy implements Session {

    private final TCPIP tcpip;

    public SessionProxy(TCPIP tcpip) {
        this.tcpip = tcpip;
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void next() {
        // TODO Auto-generated method stub

    }

    @Override
    public StateValue getValueState() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean undoable() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean redoable() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void undo() {
        // TODO Auto-generated method stub

    }

    @Override
    public void redo() {
        // TODO Auto-generated method stub

    }

    @Override
    public int getWidth() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void addProposedCombination(List<Color> colors) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isLooser() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isWinner() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getAttempts() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Color> getColors(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getBlacks(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getWhites(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    
}
