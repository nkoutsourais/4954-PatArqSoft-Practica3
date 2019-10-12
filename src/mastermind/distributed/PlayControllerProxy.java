package mastermind.distributed;

import java.util.List;

import mastermind.controllers.PlayController;
import mastermind.distributed.dispatchers.FrameType;
import mastermind.distributed.dispatchers.TCPIP;
import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.types.Error;

public class PlayControllerProxy extends PlayController {

    private final TCPIP tcpip;

    public PlayControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public Error addProposedCombination(List<Color> colors) {
        this.tcpip.send(FrameType.PROPOSE.name());
        this.tcpip.send(colors);
		return this.tcpip.receiveError();
	}

    @Override
	public boolean isWinner() {
		this.tcpip.send(FrameType.IS_WINNER.name());
        return this.tcpip.receiveBoolean();
	}

    @Override
	public boolean isLooser() {
		this.tcpip.send(FrameType.IS_LOOSER.name());
        return this.tcpip.receiveBoolean();
	}

    @Override
	public int getAttempts() {
		this.tcpip.send(FrameType.GET_ATTEMPTS.name());
		return this.tcpip.receiveInt();
	}

    @Override
	public List<Color> getColors(int position) {
        this.tcpip.send(FrameType.GET_COLORS.name());
        this.tcpip.send(position);
		return this.tcpip.recieveColors();
	}

    @Override
	public int getBlacks(int position) {
		this.tcpip.send(FrameType.GET_BLAKS.name());
        this.tcpip.send(position);
		return this.tcpip.receiveInt();
	}

    @Override
	public int getWhites(int position) {
        this.tcpip.send(FrameType.GET_WHITES.name());
        this.tcpip.send(position);
		return this.tcpip.receiveInt();
	}

    @Override
    public void undo() {
        this.tcpip.send(FrameType.UNDO.name());
    }

    @Override
    public void redo() {
        this.tcpip.send(FrameType.REDO.name());
    }

    @Override
    public boolean undoable() {
        this.tcpip.send(FrameType.UNDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public boolean redoable() {
        this.tcpip.send(FrameType.REDOABLE.name());
        return this.tcpip.receiveBoolean();
    }
}