package mastermind;

import mastermind.controllers.Logic;
import mastermind.controllers.implementation.LogicImplementation;
import mastermind.models.dao.DaoType;

public class MastermindStandalone extends Mastermind {

    public static void main(String[] args) {
        new MastermindStandalone().play();
    }

    @Override
    protected Logic createLogic() {
        return new LogicImplementation(DaoType.FILE);
    }
}