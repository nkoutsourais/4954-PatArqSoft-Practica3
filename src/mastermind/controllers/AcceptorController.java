package mastermind.controllers;

import mastermind.models.Session;
import mastermind.models.StateValue;

public abstract class AcceptorController extends Controller {

    AcceptorController(Session session) {
        super(session);
    }

    public StateValue getValueState() {
        return this.session.getValueState();
    }

    public abstract void accept(ControllersVisitor controllersVisitor);
}