package mastermind.views.console.menu;

import mastermind.controllers.PlayController;
import mastermind.utils.Menu;

public class PlayMenu extends Menu {

    public PlayMenu(PlayController playController) {
        this.addCommand(new ProposeCombinationCommand(playController));
        this.addCommand(new UndoCommand(playController));
        this.addCommand(new RedoCommand(playController));
        this.addCommand(new ExitCommand(playController));
    }
}