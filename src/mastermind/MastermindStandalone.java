package mastermind;

import mastermind.controllers.Logic;
import mastermind.controllers.implementation.LogicImplementation;
import mastermind.models.dao.DaoType;

public class MastermindStandalone extends Mastermind {

    DaoType daoType = DaoType.FILE;

    public MastermindStandalone(DaoType daoType) {
        this.daoType = daoType;
    }

    public static void main(String[] args) {
        DaoType daoType = DaoType.FILE;
        if (args.length > 0 && args[0] != null)
            daoType = DaoType.parser(args[0]);
        new MastermindStandalone(daoType).play();
    }

    @Override
    protected Logic createLogic() {
        return new LogicImplementation(this.daoType);
    }
}