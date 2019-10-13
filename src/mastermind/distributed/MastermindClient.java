package mastermind.distributed;

import mastermind.controllers.Logic;
import mastermind.Mastermind;

public class MastermindClient extends Mastermind {

    public static void main(String[] args) {
        new MastermindClient().play(new LogicProxy());
    }

    @Override
    protected void play(Logic logic) {
        super.play(logic);
        ((LogicProxy)logic).close();
    }
}