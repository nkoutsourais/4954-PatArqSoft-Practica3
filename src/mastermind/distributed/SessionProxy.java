package mastermind.distributed;

import mastermind.distributed.dispatchers.FrameType;
import mastermind.distributed.dispatchers.TCPIP;
import mastermind.models.Session;
import mastermind.models.StateValue;

public class SessionProxy implements Session {

    private final TCPIP tcpip;

    public SessionProxy(TCPIP tcpip) {
        this.tcpip = tcpip;
    }

    @Override
    public StateValue getValueState() {
        this.tcpip.send(FrameType.STATE.name());
        return StateValue.values()[this.tcpip.receiveInt()];
    }

    @Override
    public int getWidth() {
        this.tcpip.send(FrameType.WIDTH.name());
        return this.tcpip.receiveInt();
    }
    
    @Override
    public String getName() {
        this.tcpip.send(FrameType.GETTITLE.name());
        return this.tcpip.receiveLine();
    }

    @Override
    public void setName(String title) {
        this.tcpip.send(FrameType.SETTITLE.name());
        this.tcpip.send(title);
    }
}