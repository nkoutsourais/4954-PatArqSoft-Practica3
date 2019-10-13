package mastermind.views.console.menu;

import mastermind.controllers.PlayController;

public class RedoCommand extends Command {

    public RedoCommand(PlayController playController) {
        super(CommandTitle.REDO_COMMAND.getTitle(), playController);
    }

    @Override
    protected void execute() {
        ((PlayController)this.controller).redo();
    }

    @Override
    public boolean isActive() {
        return ((PlayController)this.controller).redoable();
    }
}