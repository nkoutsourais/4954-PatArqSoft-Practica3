package mastermind.views.console.menu;

public enum CommandTitle {

    PROPOSE_COMMAND("Propose a combination"),
    UNDO_COMMAND("Undo previous Proposal"),
    REDO_COMMAND("Redo previous Proposal");

    private String title;

    CommandTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}