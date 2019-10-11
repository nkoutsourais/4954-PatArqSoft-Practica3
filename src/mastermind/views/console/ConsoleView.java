package mastermind.views.console;

import mastermind.controllers.*;
import mastermind.views.View;
import mastermind.views.console.menu.PlayMenu;

public class ConsoleView extends View {
	
	private StartView startView;
	
	private ResumeView resumeView;
	
	public ConsoleView(){
		this.startView = new StartView();
		this.resumeView = new ResumeView();
	}

	@Override
	public void visit(StartController startController) {
		this.startView.interact(startController);		
	}

	@Override
	public void visit(PlayController playController ) {
		new PlayMenu(playController).execute();
	}

	@Override
	public void visit(ResumeController resumeController) {
		this.resumeView.interact(resumeController);
	}
}