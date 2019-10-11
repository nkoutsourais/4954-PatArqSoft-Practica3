package mastermind.views.console.menu;

public enum CommandTitle {

    PROPOSE_COMMAND("Propose a combination"),
    UNDO_COMMAND("Undo move"),
    REDO_COMMAND("Redo move");

    private String title;

    CommandTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}