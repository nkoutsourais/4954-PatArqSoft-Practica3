package mastermind.views.console;

import mastermind.controllers.SaveController;
import mastermind.utils.*;
import mastermind.views.MessageView;

class SaveView extends WithConsoleView {
    
    public void interact(SaveController saveController) {
        boolean save = new YesNoDialog().read(MessageView.SAVE.getMessage());
        String name = null;
        if (save) {
            if (saveController.hasName()) {
                saveController.save();
            } else {
                boolean exists = false;
                do {
                    name = this.console.readString(MessageView.NAME.getMessage());
                    exists = saveController.exists(name);
                    if (exists) {
                        this.console.writeln(MessageView.NAME_EXISTS.getMessage());
                    }
                } while (exists);
                saveController.save(name);
            }
        }
        saveController.next();
    }
}