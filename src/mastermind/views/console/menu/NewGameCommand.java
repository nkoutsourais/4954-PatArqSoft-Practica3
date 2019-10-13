package mastermind.views.console.menu;

import mastermind.controllers.StartController;

class NewGameCommand extends Command {

    protected NewGameCommand(StartController startController) {
        super(CommandTitle.NEWGAME_COMMAND.getTitle(), startController);
    }

    @Override
    protected void execute() {
        ((StartController) this.controller).start();
    }

    @Override
    public boolean isActive() {
        return true;
    }
}