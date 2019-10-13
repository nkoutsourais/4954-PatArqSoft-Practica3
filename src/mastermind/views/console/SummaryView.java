package mastermind.views.console;

import mastermind.controllers.PlayController;

class SummaryView {
	
	private PlayController playController;
	
	public SummaryView(PlayController playController){
		this.playController = playController;
	}

	public void writeln() {
		new AttemptsView(playController).writeln();
		new SecretCombinationView(playController).writeln();
	}
}