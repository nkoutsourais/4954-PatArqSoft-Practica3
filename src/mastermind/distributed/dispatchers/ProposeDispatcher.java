package mastermind.distributed.dispatchers;

import java.util.List;

import mastermind.controllers.implementation.PlayControllerImplementation;
import mastermind.types.Color;

public class ProposeDispatcher extends Dispatcher {

    public ProposeDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        List<Color> colors = this.tcpip.recieveColors();
        this.tcpip.send(((PlayControllerImplementation) this.acceptorController).addProposedCombination(colors));
    }
}