package mastermind.views.console.menu;

import mastermind.controllers.StartController;

class GameSelectCommand extends Command {

    protected GameSelectCommand(String title, StartController startController) {
        super(title, startController);
    }

    @Override
    protected void execute() {
        ((StartController) this.controller).start(this.title);
    }

    @Override
    public boolean isActive() {
        return true;
    }
}