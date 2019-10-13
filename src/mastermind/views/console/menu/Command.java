package mastermind.views.console.menu;

import mastermind.controllers.AcceptorController;

public abstract class Command extends mastermind.utils.Command {

    protected AcceptorController controller;

    protected Command(String title, AcceptorController controller) {
        super(title);
        this.controller = controller;
    }
}