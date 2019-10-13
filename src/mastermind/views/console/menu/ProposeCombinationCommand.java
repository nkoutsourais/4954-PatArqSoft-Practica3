package mastermind.views.console.menu;

import mastermind.controllers.PlayController;
import mastermind.views.console.ProposalView;

public class ProposeCombinationCommand extends Command {

    public ProposeCombinationCommand(PlayController playController) {
        super(CommandTitle.PROPOSE_COMMAND.getTitle(), playController);
    }

    @Override
    protected void execute() {
        new ProposalView().interact(((PlayController)this.controller));
    }

    @Override
    public boolean isActive() {
        return true;
    }
}