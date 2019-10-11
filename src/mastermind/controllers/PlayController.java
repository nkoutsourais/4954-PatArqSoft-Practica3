package mastermind.controllers;

import java.util.List;
import mastermind.types.Error;
import mastermind.models.Session;
import mastermind.types.Color;

public abstract class PlayController extends AcceptorController {

	public PlayController(Session session) {
		super(session);
	}

	public abstract Error addProposedCombination(List<Color> colors);

	public abstract boolean isWinner();

	public abstract boolean isLooser();

	public abstract int getAttempts();

	public abstract List<Color> getColors(int position);

	public abstract int getBlacks(int position);

	public abstract int getWhites(int position);

	public abstract void undo();

	public abstract void redo();

	public abstract boolean undoable();

	public abstract boolean redoable();

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}
}