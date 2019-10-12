package mastermind.distributed.dispatchers;

import mastermind.controllers.implementation.PlayControllerImplementation;

public class AttemptDispatcher extends Dispatcher {

    public AttemptDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(((PlayControllerImplementation) this.acceptorController).getAttempts());
    }
}