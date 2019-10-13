package mastermind;

import mastermind.controllers.implementation.LogicImplementation;
import mastermind.models.dao.DaoType;

public class MastermindStandalone extends Mastermind {

    public static void main(String[] args) {
        DaoType daoType = DaoType.FILE;
        if(args.length > 0 && args[0] != null)
            daoType = DaoType.parser(args[0]);
        new MastermindStandalone().play(new LogicImplementation(daoType));
    }
}