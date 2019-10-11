package mastermind.views.console.menu;

import mastermind.controllers.PlayController;

public class PlayMenu extends Menu {

    public PlayMenu(PlayController playController) {
        this.addCommand(new ProposeCombinationCommand(playController));
        this.addCommand(new UndoCommand(playController));
        this.addCommand(new RedoCommand(playController));
    }
}