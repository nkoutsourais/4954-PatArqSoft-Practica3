package mastermind.views.console.menu;

import mastermind.controllers.PlayController;

class ExitCommand extends Command {

    protected ExitCommand(PlayController playController) {
        super(CommandTitle.EXIT_COMMAND.getTitle(), playController);
    }

    @Override
    protected void execute() {
        ((PlayController) this.controller).next();
    }

    @Override
    public boolean isActive() {
        return true;
    }
}