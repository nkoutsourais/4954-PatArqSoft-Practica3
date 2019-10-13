package mastermind.views.console.menu;

public enum CommandTitle {

    NEWGAME_COMMAND("Start a new game"),
    OPENGAME_COMMAND("Open a saved game"),
    PROPOSE_COMMAND("Propose a combination"),
    UNDO_COMMAND("Undo previous Proposal"),
    REDO_COMMAND("Redo previous Proposal"),
    EXIT_COMMAND("Exit game");

    private String title;

    CommandTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}