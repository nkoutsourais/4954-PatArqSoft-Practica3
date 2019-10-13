package mastermind.views.console;

import mastermind.controllers.*;
import mastermind.views.View;
import mastermind.views.console.menu.PlayMenu;
import mastermind.views.console.menu.StartMenu;

public class ConsoleView extends View {
	
	private StartView startView;
	
	private ResumeView resumeView;

	private SaveView saveView;
	
	public ConsoleView(){
		this.startView = new StartView();
		this.resumeView = new ResumeView();
		this.saveView = new SaveView();
	}

	@Override
	public void visit(StartController startController) {
		this.startView.interact(startController);
		new StartMenu(startController).execute();
	}

	@Override
	public void visit(PlayController playController ) {
		new SummaryView(playController).writeln();
		new PlayMenu(playController).execute();
	}

	@Override
	public void visit(ResumeController resumeController) {
		this.resumeView.interact(resumeController);
	}

	@Override
	public void visit(SaveController saveController) {
		this.saveView.interact(saveController);
	}
}