package mastermind.controllers;

import mastermind.models.Session;

public class UndoController extends Controller {

    public UndoController(Session session) {
        super(session);
    }

    void undo() {
        this.session.undo();
    }

    boolean undoable() {
        return this.session.undoable();
    }
}