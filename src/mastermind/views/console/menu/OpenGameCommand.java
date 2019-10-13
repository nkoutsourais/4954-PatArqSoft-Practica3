package mastermind.views.console.menu;

import mastermind.controllers.StartController;

class OpenGameCommand extends Command {

    protected OpenGameCommand(StartController startController) {
        super(CommandTitle.OPENGAME_COMMAND.getTitle(), startController);
    }

    @Override
    protected void execute() {
        new GameSelectMenu((StartController) this.controller).execute();
    }

    @Override
    public boolean isActive() {
        return ((StartController) this.controller).getGamesNames().length > 0;
    }
}