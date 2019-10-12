package mastermind.distributed.dispatchers;

import mastermind.controllers.implementation.PlayControllerImplementation;

public class ColorDispatcher extends Dispatcher {

    public ColorDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        int position = this.tcpip.receiveInt();
        this.tcpip.send(((PlayControllerImplementation) this.acceptorController).getColors(position));
    }
}