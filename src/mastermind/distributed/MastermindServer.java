package mastermind.distributed;

import mastermind.distributed.dispatchers.DispatcherPrototype;
import mastermind.models.dao.DaoType;

public class MastermindServer {

    private DispatcherPrototype dispatcherPrototype;

    private MastermindServer(LogicImplementationServer logicServer) {
        this.dispatcherPrototype = new DispatcherPrototype();
        logicServer.createDispatchers(this.dispatcherPrototype);
    }

    public static void main(String[] args) {
        DaoType daoType = DaoType.FILE;
        if(args.length > 0 && args[0] != null)
            daoType = DaoType.parser(args[0]);
        LogicImplementationServer logicServer = new LogicImplementationServer(daoType);
        new MastermindServer(logicServer).serve();
    }

    private void serve() {
        this.dispatcherPrototype.serve();
    }
}