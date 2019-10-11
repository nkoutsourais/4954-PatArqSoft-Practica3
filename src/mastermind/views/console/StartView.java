package mastermind.views.console;

import mastermind.controllers.StartController;
import mastermind.views.MessageView;
import mastermind.utils.WithConsoleView;

public class StartView extends WithConsoleView {
	
	private SecretCombinationView secretCombinationView;
	
	public void interact(StartController startController) {
		startController.start();
		this.console.writeln(MessageView.TITLE.getMessage());
		this.secretCombinationView = new SecretCombinationView(startController);
		this.secretCombinationView.writeln();
	}

}
